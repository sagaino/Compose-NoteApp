package com.example.jetnote.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.jetnote.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDataBaseDao {
  @Query("SELECT * from notes_tbl ORDER BY note_entry_date DESC")
  fun getNotes():
          Flow<List<Note>>

  @Query("SELECT * from notes_tbl WHERE id =:id")
  suspend fun getNotesById(id: String): Note

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insert(note: Note)

  @Update(onConflict = OnConflictStrategy.REPLACE)
  suspend fun update(note: Note)

  @Query("DELETE from notes_tbl")
  suspend fun deleteAll()

  @Delete
  suspend fun delete(note: Note)
}
