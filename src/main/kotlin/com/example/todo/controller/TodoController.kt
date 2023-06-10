package com.example.todo.controller

import com.example.todo.domain.dto.request.TodoRequest
import com.example.todo.service.TodoService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/todo") // url 기본값으로 설정
class TodoController(
    private val todoService: TodoService
) {

    @GetMapping
    fun findAll() = todoService.findAll() // Todo 리스트를 전체 조회 하기 위한 함수

    @PostMapping // Todo 를 생성하는 함수
    fun save(@RequestBody todoRequest: TodoRequest) = todoService.save(todoRequest)

    @DeleteMapping("/{id}") // Todo 에 id값을 받아 지우는 함수
    fun deleteTodo(@PathVariable("id") id: Long) = todoService.deleteTodo(id)

    @PutMapping("/{id}") // Todo 에 id 값을 받아 Todo를 수정하는 함수
    fun updateTodo(@PathVariable("id") id: Long, @RequestBody todoRequest: TodoRequest) =
        todoService.updateTodo(id, todoRequest)
}