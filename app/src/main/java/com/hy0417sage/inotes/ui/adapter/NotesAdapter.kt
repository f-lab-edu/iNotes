package com.hy0417sage.inotes.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hy0417sage.inotes.databinding.LayoutANoteBinding
import com.hy0417sage.inotes.repository.data.ANoteEntity

class NotesAdapter :
    RecyclerView.Adapter<NotesAdapter.ViewHolder>(){

    private var notesList: List<ANoteEntity> = ArrayList()

    class ViewHolder(binding: LayoutANoteBinding) : RecyclerView.ViewHolder(binding.root) {
        val mainText = binding.mainText
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding: LayoutANoteBinding =
            LayoutANoteBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val notesList = notesList?.get(position)
        holder.mainText.text = notesList?.mainText
    }

    override fun getItemCount() = notesList.size

    fun updateNotes(notesList: List<ANoteEntity>) {
        this.notesList = notesList
        notifyDataSetChanged()
    }
}