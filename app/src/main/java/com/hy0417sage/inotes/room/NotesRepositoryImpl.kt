package com.hy0417sage.inotes.room

class NotesRepositoryImpl(private val aNoteDao: ANoteDao) : NotesRepository {

    override fun getWholeNotes() = aNoteDao.getWholeNotes()

    override suspend fun insertANote(aNoteEntity: ANoteEntity){
        aNoteDao.insertANote(aNoteEntity)
    }

    override suspend fun deleteANote(aNoteEntity: ANoteEntity){
        aNoteDao.deleteANote(aNoteEntity)
    }
}