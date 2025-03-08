package com.Kickaass_Project_01.todo_app.service;

import com.Kickaass_Project_01.todo_app.model.Task;
import com.Kickaass_Project_01.todo_app.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task createTask(String title) {
        Task task = new Task();

        task.setTitle(title);
        task.setCompleted(false);
        return taskRepository.save(task);
    }


    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public void toggleTask(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow( () -> new IllegalArgumentException("Invalid task id"));
            task.setCompleted(!task.isCompleted());
            taskRepository.save(task);
    }
}
