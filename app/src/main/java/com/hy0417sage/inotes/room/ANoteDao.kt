package com.hy0417sage.inotes.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ANoteDao {

    @Query("SELECT * FROM ANoteEntity")
    fun getWholeNotes(): LiveData<List<ANoteEntity>>

    @Insert
    suspend fun insertANote(aNote: ANoteEntity)

    @Delete
    suspend fun deleteANote(aNote: ANoteEntity)
}
