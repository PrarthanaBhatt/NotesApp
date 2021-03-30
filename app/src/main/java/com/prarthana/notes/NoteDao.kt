package com.prarthana.notes

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {

    //if normal insert then @Insert..
    // but if we want to give insert even if  repeat then onConflict ignore

    //insert runs in background thread... Coroutines...suspend to add in background thread

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: Note)

    //delete runs in background thread
    @Delete
    suspend fun delete(note: Note)

    //if we want
    @Query("Select * from notes_table order by id ASC")
    fun  getAllNotes(): LiveData<List<Note>>
}