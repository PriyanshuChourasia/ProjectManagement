package com.wishalpha.priyanshu.TaskManagementSystem.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull
    @Column(name = "team_name")
    private String teamName;

    @Column(name = "product_owner_user_id")
    private UUID productOwnerUserId;

    @Column(name = "project_management_user_id")
    private UUID projectManagerUserId;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public UUID getProductOwnerUserId() {
        return productOwnerUserId;
    }

    public void setProductOwnerUserId(UUID productOwnerUserId) {
        this.productOwnerUserId = productOwnerUserId;
    }

    public UUID getProjectManagerUserId() {
        return projectManagerUserId;
    }

    public void setProjectManagerUserId(UUID projectManagerUserId) {
        this.projectManagerUserId = projectManagerUserId;
    }


    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

}
