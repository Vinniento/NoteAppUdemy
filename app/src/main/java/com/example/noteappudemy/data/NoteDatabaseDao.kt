package com.example.noteappudemy.data

import androidx.room.*
import com.example.noteappudemy.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDatabaseDao {

    @Query("SELECT * From notes_tbl")
    fun getNotes(): Flow<List<Note>>

    @Query("SELECT * From notes_tbl where id =:id")
    suspend fun getNoteById(id: String): Note

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(note: Note)

    @Query("Delete from notes_tbl")
    suspend fun deleteAll()

    @Delete
    suspend fun delete(note: Note)

}
