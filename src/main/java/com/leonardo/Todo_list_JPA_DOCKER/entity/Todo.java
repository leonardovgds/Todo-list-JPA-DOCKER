package com.leonardo.Todo_list_JPA_DOCKER.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "task_name", length=50, nullable = false, unique=false)
    private String name;
    @Column(name = "task_description", length=200, unique=false)
    private String description;

    @Column(name = "task_status", nullable = false, unique=false)
    private Boolean isFinished;

    @Column(name = "task_priority", nullable = false, unique=false)
    private int priority;
}
