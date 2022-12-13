package com.hy0417sage.inotes.room

import androidx.lifecycle.LiveData

class NotesRepository (private val aNoteDao: ANoteDao) {

    val getAllNotes: LiveData<List<ANoteEntity>> = aNoteDao.getAllNotes()

    suspend fun insertANote(aNoteEntity: ANoteEntity){
        aNoteDao.insertANote(aNoteEntity)
    }

    suspend fun deleteANote(aNoteEntity: ANoteEntity){
        aNoteDao.deleteANote(aNoteEntity)
    }
}