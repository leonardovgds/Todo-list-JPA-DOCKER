package com.leonardo.Todo_list_JPA_DOCKER.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.leonardo.Todo_list_JPA_DOCKER.entity.Todo;
import com.leonardo.Todo_list_JPA_DOCKER.service.TodoService;

import java.util.List;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
@RequestMapping("/todos")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("todo", new Todo());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("todo") Todo todo) {
        todoService.create(todo);
        return "redirect:/todos";
    }

    @GetMapping()
    public ModelAndView list() {
        List<Todo> todos = todoService.list();
        ModelAndView mv = new ModelAndView("list");
        mv.addObject("todos", todos);
        return mv;
    }
    
    @PutMapping
    public List<Todo> update(@RequestBody Todo todo) {
        return todoService.update(todo);
    }

    //delete method
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        todoService.delete(id);
        return "redirect:/todos";
    }
    
}
