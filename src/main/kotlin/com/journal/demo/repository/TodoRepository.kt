package com.journal.demo.repository

import com.journal.demo.data.Todo
import org.springframework.data.repository.CrudRepository

interface TodoRepository : CrudRepository<Todo, String>