package com.stefanini.todo.controller;

import com.stefanini.todo.dto.TaskCreateDTO;
import com.stefanini.todo.dto.TaskDTO;
import com.stefanini.todo.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "*")
public class TaskController {

  @Autowired
  private TaskService taskService;

  @GetMapping
  public ResponseEntity<List<TaskDTO>> getAllTasks() {
    List<TaskDTO> tasks = taskService.getAllTasks();
    return ResponseEntity.ok(tasks);
  }

  @GetMapping("/{id}")
  public ResponseEntity<TaskDTO> getTaskById(@PathVariable Long id) {
    return taskService.getTaskById(id)
        .map(task -> ResponseEntity.ok(task))
        .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<TaskDTO> createTask(@Valid @RequestBody TaskCreateDTO taskCreateDTO) {
    try {
      TaskDTO createdTask = taskService.createTask(taskCreateDTO);
      return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    } catch (RuntimeException e) {
      return ResponseEntity.badRequest().build();
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<TaskDTO> updateTask(@PathVariable Long id,
      @Valid @RequestBody TaskCreateDTO taskCreateDTO) {
    try {
      return taskService.updateTask(id, taskCreateDTO)
          .map(task -> ResponseEntity.ok(task))
          .orElse(ResponseEntity.notFound().build());
    } catch (RuntimeException e) {
      return ResponseEntity.badRequest().build();
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
    if (taskService.deleteTask(id)) {
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.notFound().build();
  }
}