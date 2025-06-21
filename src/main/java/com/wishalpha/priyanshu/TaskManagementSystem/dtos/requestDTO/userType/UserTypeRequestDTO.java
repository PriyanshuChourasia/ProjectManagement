package com.wishalpha.priyanshu.TaskManagementSystem.dtos.requestDTO.userType;


import jakarta.validation.constraints.NotNull;

public class UserTypeRequestDTO {

    @NotNull(message = "Name cannot be null")
    private String name;

    private String alias;

    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
