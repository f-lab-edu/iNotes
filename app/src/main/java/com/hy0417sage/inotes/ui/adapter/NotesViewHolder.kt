package com.hy0417sage.inotes.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.hy0417sage.inotes.databinding.LayoutANoteBinding
import com.hy0417sage.inotes.repository.data.ANoteEntity

class NotesViewHolder(private val binding: LayoutANoteBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(aNote: ANoteEntity) {
        with(binding) {
            titleText.text = aNote.mainText
            if (aNote.title!!.isEmpty()) {
                titleText.text = aNote.mainText
            } else {
                titleText.text = aNote.title
            }
        }
    }
}