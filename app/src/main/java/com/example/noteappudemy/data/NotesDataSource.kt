package com.example.noteappudemy.data

import com.example.noteappudemy.model.Note

class NotesDataSource {
    fun loadNotes(): List<Note> {
        return listOf(
            Note(title = "My diary entry", description = "cool day"),
            Note(title = "My diary entry2", description = "cool day"),
            Note(title = "My diary entry3", description = "cool day"),
            Note(title = "My diary entry3", description = "cool day"),
            Note(title = "My diary entry3", description = "cool day"),
            Note(title = "My diary entry3", description = "cool day"),
            Note(title = "My diary entry3", description = "cool day"),
            Note(title = "My diary entry3", description = "cool day"),
            Note(title = "My diary entry3", description = "cool day"),
            Note(title = "My diary entry3", description = "cool day"),
            Note(title = "My diary entry3", description = "cool day"),
            Note(title = "My diary entry3", description = "cool day"),
            Note(title = "My diary entry3", description = "cool day"),
            Note(title = "My diary entry3", description = "cool day"),
            Note(title = "My diary entry3", description = "cool day"),
            Note(title = "My diary entry3", description = "cool day"),
            Note(title = "My diary entry3", description = "cool day"),
            Note(title = "My diary entry3", description = "cool day"),
            Note(title = "My diary entry4", description = "cool day")

        )
    }
}