package com.hy0417sage.inotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hy0417sage.inotes.room.ANoteEntity
import com.hy0417sage.inotes.room.NotesDataBase
import com.hy0417sage.inotes.room.NotesRepositoryImpl
import com.hy0417sage.inotes.room.NotesViewModel
import com.hy0417sage.inotes.fragment.EditANoteFragment

class ANoteActivity : AppCompatActivity() {

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
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, EditANoteFragment.newInstance())
                .commitNow()
        }
    }

    fun insertANote(aNoteEntity: ANoteEntity) = notesViewModel.insertANote(aNoteEntity)

    override fun onBackPressed() {
        super.onBackPressed()
    }

}