package com.stefanini.todo.repository;

import com.stefanini.todo.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
  Optional<Status> findByName(String name);
}