package com.journal.demo.repository

import com.journal.demo.data.Note
import org.springframework.data.repository.CrudRepository

interface NoteRepository : CrudRepository<Note, String>

