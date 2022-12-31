package com.hy0417sage.inotes.repository

import androidx.lifecycle.LiveData
import com.hy0417sage.inotes.repository.data.ANoteEntity

interface NotesRepository {
    suspend fun insertANote(aNoteEntity: ANoteEntity)
    suspend fun deleteANote(aNoteEntity: ANoteEntity)
    suspend fun updateANote(aNoteEntity: ANoteEntity)
    fun wholeNotes(): LiveData<List<ANoteEntity>>
}