package com.hy0417sage.inotes.repository

import androidx.lifecycle.LiveData
import com.hy0417sage.inotes.repository.data.ANoteEntity

interface NotesRepository {
    suspend fun insertANote(aNoteEntity: ANoteEntity)
    suspend fun deleteANote(aNoteEntity: ANoteEntity)
    fun getWholeNotes(): LiveData<List<ANoteEntity>>
}