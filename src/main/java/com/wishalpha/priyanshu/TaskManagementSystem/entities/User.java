package com.wishalpha.priyanshu.TaskManagementSystem.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_gen")
    @SequenceGenerator(name = "user_gen", sequenceName = "user_seq", allocationSize = 1)
    private Integer id;

    @Column(nullable = false)
    private String name;

//    @Column(nullable = false, unique = true)
//    private String email;

    @Column(name = "username")
    private String username;

    @Column
    private  String password;

//    @Column(name="created_at")
//    @CreationTimestamp
//    private Instant createdAt;
//
//    @Column(name="updated_at")
//    @UpdateTimestamp
//    private Instant updatedAt;
}
