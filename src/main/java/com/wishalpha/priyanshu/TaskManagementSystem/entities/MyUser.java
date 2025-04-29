package com.wishalpha.priyanshu.TaskManagementSystem.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
public class MyUser {

    @Id
    private Integer id;
    @Setter
    @Getter
    private String name;
    @Setter
    @Getter
    private String username;
    @Setter
    @Getter
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
