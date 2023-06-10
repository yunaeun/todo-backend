package com.example.todo.repository

import com.example.todo.domain.entity.Todo
import org.springframework.data.jpa.repository.JpaRepository

interface TodoRepository : JpaRepository<Todo, Long> {
}