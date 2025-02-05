package com.leonardo.Todo_list_JPA_DOCKER.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.leonardo.Todo_list_JPA_DOCKER.entity.Todo;
import com.leonardo.Todo_list_JPA_DOCKER.repository.TodoRepository;

@Service
public class TodoService {

    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> create(Todo todo) {
        todoRepository.save(todo);
        return list();
    }

    public Todo findById(Long id) {
        return todoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Task not found with ID: " + id));
    }

    public List<Todo> list() {
        Sort sort = Sort.by("priority").ascending().and(
            Sort.by("name").ascending()
        );
        return todoRepository.findAll(sort);
    }

    public List<Todo> update(Todo todo) {
        todoRepository.save(todo);
        return list();
    }

    public List<Todo> delete(Long id) {
        todoRepository.deleteById(id);
        return list();
    }

}
