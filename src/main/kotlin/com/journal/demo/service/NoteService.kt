package com.journal.demo.service

import com.journal.demo.data.Note
import com.journal.demo.data.NoteDTO
import com.journal.demo.repository.NoteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service("Note service")
class NoteService {

    @Autowired
    lateinit var repository: NoteRepository

    fun getNotes(): Iterable<NoteDTO> = repository.findAll().map { it -> NoteDTO(it)}

    fun insertNote(note: NoteDTO) = NoteDTO(
            repository.save(
                    Note(
                            title = note.title,
                            message = note.message,
                            location = note.location
                    )
            )
    )

    fun deleteNote(id: String) = repository.deleteById(id)

    fun updateNote(noteDto: NoteDTO): NoteDTO {
        var note = repository.findById(noteDto.id).get()
        note.title = noteDto.title
        note.message = noteDto.message
        note.location = noteDto.location
        note.modified = Date()
        note = repository.save(note)
        return NoteDTO(note)
    }
}