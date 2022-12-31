package com.hy0417sage.inotes.repository.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.hy0417sage.inotes.repository.data.ANoteEntity

@Dao
interface ANoteDao {

    @Query("SELECT * FROM ANoteEntity")
    fun wholeNotes(): LiveData<List<ANoteEntity>>

    @Insert
    suspend fun insertANote(aNote: ANoteEntity)

    @Delete
    suspend fun deleteANote(aNote: ANoteEntity)

    @Update
    suspend fun updateANote(aNote: ANoteEntity)
}
