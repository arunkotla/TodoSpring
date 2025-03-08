package com.Kickaass_Project_01.todo_app.repository;

import com.Kickaass_Project_01.todo_app.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {   // <Task, Long> is <entity name> and the <datatype> of primary id
}
