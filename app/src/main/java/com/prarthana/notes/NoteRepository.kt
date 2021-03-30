package com.prarthana.notes

import androidx.lifecycle.LiveData

//it is just simple class (gives layer) to provide cleaner api
// not part of architecture or
// component not part of room
class NoteRepository(private val noteDao: NoteDao) {

    //so that viewmodel will not have to worry that from where data is been  taken
    // now that data comes from dao...it can be from calling api
    val allNotes: LiveData<List<Note>> = noteDao.getAllNotes()



    suspend fun insert(note: Note){
        noteDao.insert(note)
    }

    suspend fun delete(note: Note){
        noteDao.delete(note)
    }
}