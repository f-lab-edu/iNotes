package com.hy0417sage.inotes.module

import android.content.Context
import androidx.room.Room
import com.hy0417sage.inotes.repository.NotesRepository
import com.hy0417sage.inotes.repository.database.ANoteDao
import com.hy0417sage.inotes.repository.database.NotesDataBase
import com.hy0417sage.inotes.repository.impl.NotesRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DIModule {
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): NotesDataBase.NotesDB {
        return Room.databaseBuilder(
            context.applicationContext,
            NotesDataBase.NotesDB::class.java,
            "Notes.db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideANoteDao(appDataBase: NotesDataBase.NotesDB): ANoteDao {
        return appDataBase.aNoteDao()
    }

    @Singleton
    @Provides
    fun provideRepository(
        noteDAO: ANoteDao
    ): NotesRepository {
        return NotesRepositoryImpl(noteDAO)
    }
}
