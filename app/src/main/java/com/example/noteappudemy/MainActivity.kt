package com.example.noteappudemy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.noteappudemy.data.NotesDataSource
import com.example.noteappudemy.model.Note
import com.example.noteappudemy.screen.NoteScreen
import com.example.noteappudemy.screen.NoteViewModel
import com.example.noteappudemy.ui.theme.NoteAppUdemyTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteAppUdemyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val noteViewModel = viewModel<NoteViewModel>()
                    NotesApp(noteViewModel)

                }
            }
        }
    }
}

@Composable
fun NotesApp(notesViewModel: NoteViewModel) {
    val noteList = notesViewModel.noteList.collectAsState().value
    NoteScreen(
        notes = noteList,
        onAddNote = { notesViewModel.addNote(it) },
        onRemoveNote = { notesViewModel.deleteNote(it) })
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NoteAppUdemyTheme {

    }
}