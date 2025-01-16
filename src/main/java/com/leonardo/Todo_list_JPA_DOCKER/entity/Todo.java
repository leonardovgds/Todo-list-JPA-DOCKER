package com.leonardo.Todo_list_JPA_DOCKER.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor


public class Todo {

    private Long id;

    private String name;
    private String description;
    private Boolean isFinished;
    private int priority;
}
