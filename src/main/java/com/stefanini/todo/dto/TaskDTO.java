package com.stefanini.todo.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TaskDTO {
  private Long id;
  private String title;
  private String description;
  private LocalDateTime createdAt;
  private LocalDate dueDate;
  private String status;

  // Constructors
  public TaskDTO() {
  }

  public TaskDTO(Long id, String title, String description, LocalDateTime createdAt,
      LocalDate dueDate, String status) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.createdAt = createdAt;
    this.dueDate = dueDate;
    this.status = status;
  }

  // Getters and Setters
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public LocalDate getDueDate() {
    return dueDate;
  }

  public void setDueDate(LocalDate dueDate) {
    this.dueDate = dueDate;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}