package com.hy0417sage.inotes.room

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesViewModel(private val notesRepository : NotesRepositoryImpl) : ViewModel() {

    fun getWholeNotes() = notesRepository.getWholeNotes()

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