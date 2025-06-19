package com.wishalpha.priyanshu.TaskManagementSystem.config.jwt;

import com.wishalpha.priyanshu.TaskManagementSystem.services.impl.MyUserDetailServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class AuthTokenFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(AuthTokenFilter.class);
    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private MyUserDetailServiceImpl userDetailService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpRequest, HttpServletResponse response, FilterChain filterChain) throws ServletException , IOException {
        logger.debug("AuthTokenFilter called for URI {}",httpRequest.getRequestURI());
        try {
            String jwt = parseJWT(httpRequest);
            if(jwt != null && jwtUtils.validateJwtToken(jwt)){
                String username = jwtUtils.getUserNameFromJwtToken(jwt);

                UserDetails userDetails = userDetailService.loadUserByUsername(username);

                UsernamePasswordAuthenticationToken authenticationToken =  new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());

                logger.debug("Roles from JWT: {}", userDetails.getAuthorities());

                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpRequest));

                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }catch (Exception e){
            logger.warn("Cannot set user authentication {}",e.getMessage());
        }
        filterChain.doFilter(httpRequest,response);
    }

    private String parseJWT(HttpServletRequest request){
        String jwt = jwtUtils.getJwtFromHeader(request);
        logger.debug("AuthToken filter java: {}",jwt);
        return jwt;
    }


}
