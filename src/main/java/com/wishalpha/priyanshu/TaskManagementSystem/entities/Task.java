package com.wishalpha.priyanshu.TaskManagementSystem.entities;


import jakarta.persistence.*;
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
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String title;

    // version of the document
    private String version;

    private String description;

    private String status;

    private String priority;

    private String tags;

    @Column(name = "task_file_url")
    private String taskFileURL;

    // task assigned date
    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "due_date")
    private LocalDateTime dueDate;

    @Column(name = "project_id")
    private UUID projectId;

    // who is authorising this project means the team leader
    @Column(name = "author_user_id")
    private UUID authorUserId;

    // person who is being assigned to
    @Column(name = "assigned_user_id")
    private UUID assignedUserId;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updateAt;

}
