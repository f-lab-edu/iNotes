package com.hy0417sage.inotes.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hy0417sage.inotes.repository.impl.NotesRepositoryImpl
import com.hy0417sage.inotes.repository.data.ANoteEntity
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