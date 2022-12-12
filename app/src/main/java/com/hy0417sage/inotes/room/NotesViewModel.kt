package com.hy0417sage.inotes.room

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesViewModel(application: Application) : ViewModel() {

    private val aNoteDao = NotesDataBase.getInstance(application).getANoteDao()
    private val notesData: LiveData<List<ANoteEntity>>
    private val notesRepository = NotesRepository(aNoteDao)

    init {
        notesData = notesRepository.getAllNotes
    }

    fun getNotesData() = notesData

    fun insertANote(aNoteEntity: ANoteEntity){
        viewModelScope.launch(Dispatchers.IO) {
            notesRepository.insertANote(aNoteEntity)
        }
    }

    fun deleteANote(aNoteEntity: ANoteEntity){
        viewModelScope.launch(Dispatchers.IO) {
            notesRepository.deleteANote(aNoteEntity)
        }
    }
}