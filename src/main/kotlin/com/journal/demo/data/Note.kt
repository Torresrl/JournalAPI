package com.journal.demo.data

import com.fasterxml.jackson.annotation.JsonInclude
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import org.hibernate.annotations.GenericGenerator
import javax.persistence.*
import java.util.*

@Entity
@Table(name = "note")
@JsonInclude(JsonInclude.Include.NON_NULL)
data class Note(
        @Id
        @GeneratedValue(generator = "uuid2")
        @GenericGenerator(name = "uuid2", strategy = "uuid2")
        @Column(columnDefinition = "varchar(36)")
        var id: String="",
        var title: String,
        var message: String,
        var location: String = "",

        @CreationTimestamp
        var created: Date = Date(),
        @UpdateTimestamp
        var modified: Date = Date()



) {
    constructor() : this( "","","", "")
}