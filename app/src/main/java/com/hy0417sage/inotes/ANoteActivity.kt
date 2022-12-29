package com.hy0417sage.inotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hy0417sage.inotes.repository.data.ANoteEntity
import com.hy0417sage.inotes.repository.database.NotesDataBase
import com.hy0417sage.inotes.repository.impl.NotesRepositoryImpl
import com.hy0417sage.inotes.ui.EditANoteFragment
import com.hy0417sage.inotes.ui.ViewANoteFragment
import com.hy0417sage.inotes.viewmodel.NotesViewModel

class ANoteActivity : AppCompatActivity() {

    var noteTitle: String? = null
    var noteMainText: String? = null
    var noteId: Int = -1

    private val notesViewModel by viewModels<NotesViewModel> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                val aNoteDao = NotesDataBase.getInstance(application).getANoteDao()
                return NotesViewModel(NotesRepositoryImpl(aNoteDao)) as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a_note)

        noteId = intent.getIntExtra("id", -1)
        noteTitle = intent.getStringExtra("title")
        noteMainText = intent.getStringExtra("mainText")

        fragmentViewChange(signal = noteId)
    }

    fun fragmentViewChange(signal: Int) {
        when (signal) {
            -1, EDIT_SIGNAL -> supportFragmentManager.beginTransaction()
                .replace(R.id.container, EditANoteFragment.newInstance())
                .commit()
            else -> supportFragmentManager.beginTransaction()
                .replace(R.id.container, ViewANoteFragment.newInstance())
                .commit()
        }
    }

    fun insertANote(aNoteEntity: ANoteEntity) {
        notesViewModel.insertANote(aNoteEntity)
    }

    fun updateANote(aNoteEntity: ANoteEntity) {
        notesViewModel.updateANote(aNoteEntity)
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    companion object {
        const val EDIT_SIGNAL: Int = 1000000000
    }

}