package com.example.todo.service

import com.example.todo.domain.dto.request.TodoRequest
import com.example.todo.domain.entity.Todo
import com.example.todo.repository.TodoRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class TodoService(
    private val todoRepository: TodoRepository
) {
    fun findAll(): List<Todo> {
        return todoRepository.findAll() // Todo Table에서 데이터를 가져와 전체 조회 하는 함수
    }

    fun save(todoRequest: TodoRequest) { // Todo 테이블에 Todo를 저장하는 함수
        todoRepository.save(Todo(0, todoRequest.title, todoRequest.description))
    }

    fun deleteTodo(id: Long) { // Todo id 를 가져와 해당하는 Todo를 지우는 함수
        todoRepository.deleteById(id)
    }

    fun updateTodo(id: Long, todoRequest: TodoRequest) { // Todo id와 Todo가 수정된 title, description을 바탕으로 Todo를 수정하는 함수
        val todo = todoRepository.findByIdOrNull(id) ?: throw RuntimeException("todo 엔티티를 못찾음")
        todoRepository.save(Todo(todo.id, todoRequest.title, todoRequest.description))
    }
}