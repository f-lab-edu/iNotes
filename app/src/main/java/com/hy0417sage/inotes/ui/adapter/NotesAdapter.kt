package com.hy0417sage.inotes.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hy0417sage.inotes.databinding.LayoutANoteBinding
import com.hy0417sage.inotes.repository.data.ANoteEntity

class NotesAdapter : ListAdapter<ANoteEntity, RecyclerView.ViewHolder>(NotesDiffCallback()) {

    private lateinit var itemClickListener: OnItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return NotesViewHolder(
            LayoutANoteBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is NotesViewHolder) {
            val aNote = getItem(position) as ANoteEntity
            holder.bind(aNote)
            holder.itemView.setOnClickListener {
                itemClickListener?.onClick(aNote)
            }
        }
    }

    fun interface OnItemClickListener {
        fun onClick(aNote: ANoteEntity)
    }

    fun setItemClickListener(onItemClickListener: OnItemClickListener) {
        this.itemClickListener = onItemClickListener
    }
}