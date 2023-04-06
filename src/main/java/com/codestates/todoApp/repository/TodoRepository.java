package com.codestates.todoApp.repository;

import com.codestates.todoApp.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo,Long> {
}
