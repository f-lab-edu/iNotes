package com.hy0417sage.inotes.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.hy0417sage.inotes.R
import com.hy0417sage.inotes.databinding.ActivityMainBinding
import com.hy0417sage.inotes.repository.data.ANoteEntity
import com.hy0417sage.inotes.ui.ANoteActivity.Companion.newIntent
import com.hy0417sage.inotes.ui.adapter.NotesAdapter
import com.hy0417sage.inotes.viewmodel.NotesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val notesAdapter: NotesAdapter = NotesAdapter()

    private val notesViewModel: NotesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        recyclerViewInit()

        binding.createANoteButton.setOnClickListener {
            val goANote = Intent(this, ANoteActivity::class.java)
            startActivity(goANote)
        }

        notesAdapter.setItemClickListener { aNote ->
            openDetailPage(aNote)
        }

        notesViewModel.wholeNotes().observe(this, Observer { wholeNotes ->
            notesAdapter.submitList(wholeNotes)
        })
    }

    private fun recyclerViewInit() {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = notesAdapter
            addItemDecoration(
                DividerItemDecoration(
                    this@MainActivity,
                    LinearLayoutManager.VERTICAL
                )
            )
        }
    }

    private fun openDetailPage(aNoteEntity: ANoteEntity) {
        val goANote = newIntent(this, aNoteEntity.id, aNoteEntity.title, aNoteEntity.mainText)
        startActivity(goANote)
    }
}