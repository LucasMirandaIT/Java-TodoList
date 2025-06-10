package com.stefanini.todo.service;

import com.stefanini.todo.dto.TaskCreateDTO;
import com.stefanini.todo.dto.TaskDTO;
import com.stefanini.todo.model.Status;
import com.stefanini.todo.model.Task;
import com.stefanini.todo.repository.StatusRepository;
import com.stefanini.todo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {

  @Autowired
  private TaskRepository taskRepository;

  @Autowired
  private StatusRepository statusRepository;

  public List<TaskDTO> getAllTasks() {
    return taskRepository.findAll().stream()
        .map(this::convertToDTO)
        .collect(Collectors.toList());
  }

  public Optional<TaskDTO> getTaskById(Long id) {
    return taskRepository.findById(id)
        .map(this::convertToDTO);
  }

  public TaskDTO createTask(TaskCreateDTO taskCreateDTO) {
    Status status = statusRepository.findByName(taskCreateDTO.getStatus())
        .orElseThrow(() -> new RuntimeException("Status not found: " + taskCreateDTO.getStatus()));

    Task task = new Task();
    task.setTitle(taskCreateDTO.getTitle());
    task.setDescription(taskCreateDTO.getDescription());

    // Set due_date based on status
    LocalDate dueDate = calculateDueDate(taskCreateDTO.getStatus(), taskCreateDTO.getDueDate());
    task.setDueDate(dueDate);
    task.setStatus(status);

    Task savedTask = taskRepository.save(task);
    return convertToDTO(savedTask);
  }

  public Optional<TaskDTO> updateTask(Long id, TaskCreateDTO taskCreateDTO) {
    return taskRepository.findById(id)
        .map(task -> {
          Status status = statusRepository.findByName(taskCreateDTO.getStatus())
              .orElseThrow(() -> new RuntimeException("Status not found: " + taskCreateDTO.getStatus()));

          task.setTitle(taskCreateDTO.getTitle());
          task.setDescription(taskCreateDTO.getDescription());

          // Set due_date based on status - if changing to COMPLETED or CANCELED, set to
          // today
          LocalDate dueDate = calculateDueDate(taskCreateDTO.getStatus(), taskCreateDTO.getDueDate());
          task.setDueDate(dueDate);
          task.setStatus(status);

          Task updatedTask = taskRepository.save(task);
          return convertToDTO(updatedTask);
        });
  }

  public boolean deleteTask(Long id) {
    if (taskRepository.existsById(id)) {
      taskRepository.deleteById(id);
      return true;
    }
    return false;
  }

  /**
   * Calculate due date based on status
   * If status is COMPLETED or CANCELED, set due_date to today
   * Otherwise, use the provided due_date
   */
  private LocalDate calculateDueDate(String statusName, LocalDate providedDueDate) {
    if ("COMPLETED".equals(statusName) || "CANCELED".equals(statusName)) {
      return LocalDate.now(); // Set to today
    }
    return providedDueDate; // Use provided date
  }

  private TaskDTO convertToDTO(Task task) {
    return new TaskDTO(
        task.getId(),
        task.getTitle(),
        task.getDescription(),
        task.getCreatedAt(),
        task.getDueDate(),
        task.getStatus().getName());
  }
}