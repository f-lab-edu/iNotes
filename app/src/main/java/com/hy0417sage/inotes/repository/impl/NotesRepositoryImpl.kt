package com.hy0417sage.inotes.repository.impl

import com.hy0417sage.inotes.repository.NotesRepository
import com.hy0417sage.inotes.repository.database.ANoteDao
import com.hy0417sage.inotes.repository.data.ANoteEntity

class NotesRepositoryImpl(private val aNoteDao: ANoteDao) : NotesRepository {

    override fun wholeNotes() = aNoteDao.wholeNotes()

    override suspend fun insertANote(aNoteEntity: ANoteEntity){
        aNoteDao.insertANote(aNoteEntity)
    }

    override suspend fun deleteANote(aNoteEntity: ANoteEntity){
        aNoteDao.deleteANote(aNoteEntity)
    }

    override suspend fun updateANote(aNoteEntity: ANoteEntity) {
        aNoteDao.updateANote(aNoteEntity)
    }
}