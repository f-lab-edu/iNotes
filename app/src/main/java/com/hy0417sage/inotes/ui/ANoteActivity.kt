package com.hy0417sage.inotes.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.hy0417sage.inotes.R
import com.hy0417sage.inotes.repository.data.ANoteEntity
import com.hy0417sage.inotes.viewmodel.NotesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ANoteActivity : AppCompatActivity() {

    var noteTitle: String? = null
    var noteMainText: String? = null
    var noteId: Int = -1

    private val notesViewModel: NotesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a_note)
        noteId = intent.getIntExtra("id", -1)
        noteTitle = intent.getStringExtra("title")
        noteMainText = intent.getStringExtra("mainText")
        fragmentViewChange(signal = noteId)
    }

    fun changeNote(noteTitle: String, noteMainText: String) {
        this.noteTitle = noteTitle
        this.noteMainText = noteMainText
    }

    fun fragmentViewChange(signal: Int) {
        when (signal) {
            CREATE_SIGNAL, EDIT_SIGNAL -> supportFragmentManager.beginTransaction()
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

    fun deleteANote(aNoteEntity: ANoteEntity) {
        notesViewModel.deleteANote(aNoteEntity)
    }

    fun updateANote(aNoteEntity: ANoteEntity) {
        notesViewModel.updateANote(aNoteEntity)
    }

    companion object {
        const val CREATE_SIGNAL: Int = -1
        const val EDIT_SIGNAL: Int = -2
        fun newIntent(context: Context, id: Int?, title: String?, mainText: String?): Intent =
            Intent(context, ANoteActivity::class.java).apply {
                putExtra("id", id)
                putExtra("title", title)
                putExtra("mainText", mainText)
            }
    }
}