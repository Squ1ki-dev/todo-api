package com.squ1ki.todo_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.squ1ki.todo_api.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}