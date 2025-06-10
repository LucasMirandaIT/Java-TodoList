package com.stefanini.todo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class TaskCreateDTO {
  @NotBlank(message = "Title is required")
  private String title;

  private String description;

  private LocalDate dueDate;

  @NotNull(message = "Status is required")
  private String status;

  // Constructors
  public TaskCreateDTO() {
  }

  public TaskCreateDTO(String title, String description, LocalDate dueDate, String status) {
    this.title = title;
    this.description = description;
    this.dueDate = dueDate;
    this.status = status;
  }

  // Getters and Setters
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