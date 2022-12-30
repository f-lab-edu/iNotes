package com.hy0417sage.inotes.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.hy0417sage.inotes.repository.data.ANoteEntity

class NotesDiffCallback : DiffUtil.ItemCallback<ANoteEntity>() {

    override fun areItemsTheSame(oldItem: ANoteEntity, newItem: ANoteEntity): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }

    override fun areContentsTheSame(oldItem: ANoteEntity, newItem: ANoteEntity): Boolean {
        return oldItem == newItem
    }
}