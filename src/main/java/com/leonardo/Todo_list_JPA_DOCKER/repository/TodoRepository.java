package com.leonardo.Todo_list_JPA_DOCKER.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leonardo.Todo_list_JPA_DOCKER.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>{

}
