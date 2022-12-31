package com.hy0417sage.inotes.repository.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hy0417sage.inotes.repository.data.ANoteEntity

@Database(entities = [ANoteEntity::class], version = 1, exportSchema = false)
abstract class NotesDataBase : RoomDatabase() {

    abstract fun getANoteDao(): ANoteDao

    abstract class NotesDB : RoomDatabase() {
        abstract fun aNoteDao(): ANoteDao
    }
}