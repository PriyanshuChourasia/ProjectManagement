package com.wishalpha.priyanshu.TaskManagementSystem.services.impl;

import com.wishalpha.priyanshu.TaskManagementSystem.entities.MyUser;
import com.wishalpha.priyanshu.TaskManagementSystem.repositories.UserPrincipal;
import com.wishalpha.priyanshu.TaskManagementSystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDataServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException{

        MyUser user = userRepository.findByUsername(username);

        if(user == null)
        {
            System.out.println("Users not found");
            throw new UsernameNotFoundException("User not found");
        }
        return new UserPrincipal(user);
    }
}
