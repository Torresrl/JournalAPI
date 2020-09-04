package com.journal.demo.controller

import com.journal.demo.data.Note
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/notes")
@EnableAutoConfiguration
class NoteController {

    @GetMapping(
            produces = arrayOf(MediaType.APPLICATION_JSON_VALUE)
    )

    fun getNotes() : List<Note> {
        return listOf(
                Note(
                        UUID.randomUUID().toString(),
                        "My first note",
                        "This is a meassege for the first note."
                ),
                Note(
                        UUID.randomUUID().toString(),
                        "My second note",
                        "This is a message for the 2nd note."
                )
        )
    }

    @PutMapping(
            produces = arrayOf(MediaType.APPLICATION_JSON_VALUE),
            consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE)
    )
    fun insertNote(
            @RequestBody note: Note
    ): Note {
        note.id = UUID.randomUUID().toString()
        return note
    }

    @DeleteMapping(
            value = ["/delete/{id}"],
            produces = arrayOf(MediaType.APPLICATION_JSON_VALUE)
    )
    fun deleteNote(@PathVariable(name="id") id: String): Boolean {
        println("Removing: $id")
        return true
    }

    @PostMapping(
            produces = arrayOf(MediaType.APPLICATION_JSON_VALUE),
            consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE)
    )
    fun updateNote(@RequestBody note:Note): Note {
        note.title += " [ updated ] "
        note.message += " [ updated ] "
        return note
    }
}