package com.journal.demo.controller

import com.journal.demo.data.Todo
import com.journal.demo.data.TodoDTO
import org.springframework.http.MediaType
import com.journal.demo.service.TodoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/todos")
class TodoController {

    @Autowired
    private lateinit var service: TodoService

    @GetMapping(
            produces = arrayOf(MediaType.APPLICATION_JSON_VALUE)
    )
    fun getTodos(): Iterable<TodoDTO> = service.getTodos()

    @PutMapping(
            produces = arrayOf(MediaType.APPLICATION_JSON_VALUE),
            consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE)
    )
    fun insertTodo(@RequestBody todo: TodoDTO): TodoDTO = service.insertTodo(todo)

    @DeleteMapping(
            value = ["/{id}"],
            produces = arrayOf(MediaType.APPLICATION_JSON_VALUE)
    )
    fun deleteTodo(@PathVariable(name="id") id: String) = service.deleteTodo(id)

    @PostMapping(
            produces = arrayOf(MediaType.APPLICATION_JSON_VALUE),
            consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE)
    )
    fun updateTodo(@RequestBody todo: TodoDTO) = service.updateTodo(todo)
}