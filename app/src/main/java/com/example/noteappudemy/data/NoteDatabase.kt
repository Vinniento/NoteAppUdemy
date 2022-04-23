package com.example.noteappudemy.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.noteappudemy.model.Note
import com.example.noteappudemy.util.DateConverter
import com.example.noteappudemy.util.UUIDConverter


@Database(entities = [Note::class], version = 1)
@TypeConverters(DateConverter::class, UUIDConverter::class)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun noteDao() : NoteDatabaseDao
}