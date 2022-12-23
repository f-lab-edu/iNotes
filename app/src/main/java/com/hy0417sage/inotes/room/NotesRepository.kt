package com.hy0417sage.inotes.room

import androidx.lifecycle.LiveData

interface NotesRepository {
    suspend fun insertANote(aNoteEntity: ANoteEntity)
    suspend fun deleteANote(aNoteEntity: ANoteEntity)
    fun getWholeNotes(): LiveData<List<ANoteEntity>>
}