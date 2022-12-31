package com.hy0417sage.inotes.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hy0417sage.inotes.repository.NotesRepository
import com.hy0417sage.inotes.repository.data.ANoteEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(private val notesRepository: NotesRepository) :
    ViewModel() {

    fun wholeNotes() = notesRepository.wholeNotes()

    fun insertANote(aNoteEntity: ANoteEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            notesRepository.insertANote(aNoteEntity)
        }
    }

    fun deleteANote(aNoteEntity: ANoteEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            notesRepository.deleteANote(aNoteEntity)
        }
    }

    fun updateANote(aNoteEntity: ANoteEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            notesRepository.updateANote(aNoteEntity)
        }
    }
}