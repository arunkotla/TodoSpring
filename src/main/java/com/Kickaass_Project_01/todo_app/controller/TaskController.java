package com.Kickaass_Project_01.todo_app.controller;


import com.Kickaass_Project_01.todo_app.model.Task;
import com.Kickaass_Project_01.todo_app.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Scanner;

@Controller
@RequestMapping
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String getTasks(Model model){
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute( "tasks", tasks);
        return "tasks";
    }

    @GetMapping("/{id}/delete")
    public String deleteTasks(@PathVariable Long id){
        taskService.deleteTask(id);
        return "redirect:/";
    }

    @GetMapping("/{id}/toggle")
    public String toggleTasks(@PathVariable Long id){
        taskService.toggleTask(id);
        return "redirect:/";
    }

    @PostMapping
    public String createTask(@RequestParam String title){
         taskService.createTask(title);
         return "redirect:/";

    }

}
