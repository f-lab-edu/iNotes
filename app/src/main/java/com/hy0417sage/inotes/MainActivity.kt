package com.hy0417sage.inotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.hy0417sage.inotes.databinding.ActivityMainBinding
import com.hy0417sage.inotes.repository.database.NotesDataBase
import com.hy0417sage.inotes.repository.impl.NotesRepositoryImpl
import com.hy0417sage.inotes.ui.adapter.NotesAdapter
import com.hy0417sage.inotes.viewmodel.NotesViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val notesAdapter: NotesAdapter = NotesAdapter()

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
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.button.setOnClickListener {
            val goANoteActivity = Intent(this, ANoteActivity::class.java)
            startActivity(goANoteActivity)
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = notesAdapter
        binding.recyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))

        notesViewModel.wholeNotes().observe(this, Observer { wholeNotes ->
            notesAdapter.updateNotes(wholeNotes)
        })
    }
}