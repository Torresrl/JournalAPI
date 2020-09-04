package com.journal.demo.controller

import com.journal.demo.data.Todo
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/todos")
class TodoController {
    @GetMapping(
            produces = arrayOf(MediaType.APPLICATION_JSON_VALUE)
    )
    fun getTodos(): List<Todo> {
        return listOf(
                Todo(
                        UUID.randomUUID().toString(),
                        "My first todo",
                        "This is a message for the 1st todo.",
                        System.currentTimeMillis()
                ),
                Todo(
                        UUID.randomUUID().toString(),
                        "My second todo",
                        "This is a message for the 2nd todo.",
                        System.currentTimeMillis()
                )
        )
    }

    @PutMapping(
            produces = arrayOf(MediaType.APPLICATION_JSON_VALUE),
            consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE)
    )
    fun insertTodo(
            @RequestBody todo: Todo
    ): Todo {
        todo.id == UUID.randomUUID().toString()
        return todo
    }

    @DeleteMapping(
            value = ["/delete/{id}"],
            produces = arrayOf(MediaType.APPLICATION_JSON_VALUE)
    )
    fun deleteTodo(@PathVariable(name="id") id: String): Boolean {
        println("Removing: $id")
        return true
    }

    @PostMapping(
            produces = arrayOf(MediaType.APPLICATION_JSON_VALUE),
            consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE)
    )
    fun updateTodo(@RequestBody todo: Todo): Todo {
        todo.title += " [ updated ] "
        todo.message += " [ updated ] "
        todo.schedule = System.currentTimeMillis()
        return todo
    }
}