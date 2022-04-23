package com.example.noteappudemy.screen

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteappudemy.data.NotesDataSource
import com.example.noteappudemy.model.Note
import com.example.noteappudemy.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val repository: NoteRepository) : ViewModel() {

    private val _noteList = MutableStateFlow<List<Note>>(emptyList())

    val noteList = _noteList.asStateFlow()


    fun addNote(note: Note) = viewModelScope.launch { repository.addNote(note) }
    fun deleteNote(note: Note) = viewModelScope.launch { repository.deleteNote(note) }
    fun updateNote(note: Note) = viewModelScope.launch { repository.updateNote(note) }
    fun deleteAllNotes() = viewModelScope.launch { repository.deleteAllNotes() }
    fun getNoteById(id: String) = viewModelScope.launch { repository.getNoteById(id) }

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllNotes().distinctUntilChanged().collect { listofNotes ->
                if (listofNotes.isNullOrEmpty())
                    Log.d("noteviewmodel", "Empty list")
                else
                    _noteList.value = listofNotes
            }
        }
    }
}