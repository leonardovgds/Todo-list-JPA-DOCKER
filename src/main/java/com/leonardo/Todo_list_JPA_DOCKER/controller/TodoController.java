package com.leonardo.Todo_list_JPA_DOCKER.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.leonardo.Todo_list_JPA_DOCKER.entity.Todo;
import com.leonardo.Todo_list_JPA_DOCKER.service.TodoService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable("id") Long id, Model model) {
        Todo todo = todoService.findById(id);
        model.addAttribute("todo", todo);
        return "edit";
    }
    
    @PostMapping("/edit/{id}")
    public String updateTodo(@PathVariable("id") 
        Long id, @ModelAttribute("todo") Todo updatedTodo) {
           Todo existingTodo = todoService.findById(id);

            //update values
            existingTodo.setName(updatedTodo.getName());
            existingTodo.setDescription(updatedTodo.getDescription());
            existingTodo.setPriority(updatedTodo.getPriority());
            existingTodo.setIsFinished(updatedTodo.getIsFinished());

            todoService.create(existingTodo);
            return "redirect:/todos";
        }

    //delete method
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        todoService.delete(id);
        return "redirect:/todos";
    }

    //update task status
    @PostMapping("/toggle/{id}")
    public ResponseEntity<Map<String, String>> toggleTodoStatus(@PathVariable Long id) {
        // Busca a tarefa pelo ID
        Todo todo = todoService.findById(id);

        // Inverte o status (concluído/não concluído)
        todo.setIsFinished(!todo.getIsFinished());

        todoService.create(todo);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Status Updated");
        response.put("isFinished", Boolean.toString(todo.getIsFinished()));
        return ResponseEntity.ok(response);
    }
}
