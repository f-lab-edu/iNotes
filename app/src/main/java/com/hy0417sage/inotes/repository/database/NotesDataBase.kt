package com.hy0417sage.inotes.repository.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hy0417sage.inotes.repository.data.ANoteEntity

@Database(entities = [ANoteEntity::class], version = 1, exportSchema = false)
abstract class NotesDataBase : RoomDatabase() {

    abstract fun getANoteDao(): ANoteDao

    companion object{
        @Volatile
        private var INSTANCE: NotesDataBase? = null

        fun getInstance(
            context: Context
        ) : NotesDataBase {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NotesDataBase::class.java,
                    "Notes.db"
                )
                    .fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instance
                instance
            }
        }
    }
}