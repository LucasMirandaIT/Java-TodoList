package com.stefanini.todo.repository;

import com.stefanini.todo.model.Task;
import com.stefanini.todo.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

  List<Task> findByStatus(Status status);

  @Query("SELECT t FROM Task t WHERE t.status.name = :statusName")
  List<Task> findByStatusName(@Param("statusName") String statusName);

  List<Task> findByTitleContainingIgnoreCase(String title);
}