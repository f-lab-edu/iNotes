package com.hy0417sage.inotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.Observer
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.hy0417sage.inotes.databinding.ActivityMainBinding
import com.hy0417sage.inotes.room.NotesRepository
import com.hy0417sage.inotes.room.NotesViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val notesAdapter: NotesAdapter = NotesAdapter()

    private val notesViewModel by lazy {
        ViewModelProvider(this, object : AbstractSavedStateViewModelFactory(this@MainActivity, null) {
            override fun <T : ViewModel> create(key: String, modelClass: Class<T>, handle: SavedStateHandle): T {
                return NotesViewModel(application) as T
            }
        })[NotesViewModel::class.java]
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

        notesViewModel.getNotesData().observe(this, Observer { loadNotes ->
            notesAdapter.updateNotes(loadNotes)
        })
    }
}