package com.stefanini.todo.model;

public enum TaskStatus {
  PENDING("PENDING"),
  IN_PROGRESS("IN_PROGRESS"),
  COMPLETED("COMPLETED"),
  CANCELED("CANCELED");

  private final String value;

  TaskStatus(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public static TaskStatus fromString(String text) {
    for (TaskStatus status : TaskStatus.values()) {
      if (status.value.equalsIgnoreCase(text)) {
        return status;
      }
    }
    throw new IllegalArgumentException("No status with text " + text + " found");
  }
}