package com.hy0417sage.inotes.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hy0417sage.inotes.ANoteActivity
import com.hy0417sage.inotes.R
import com.hy0417sage.inotes.databinding.FragmentEditANoteBinding
import com.hy0417sage.inotes.databinding.FragmentViewANoteBinding
import com.hy0417sage.inotes.repository.data.ANoteEntity
import com.hy0417sage.inotes.viewmodel.NotesViewModel

class ViewANoteFragment : Fragment() {

    private lateinit var aNoteActivity: ANoteActivity
    private lateinit var binding: FragmentViewANoteBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ANoteActivity) aNoteActivity = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentViewANoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.aNoteTitle.text = aNoteActivity.noteTitle.toString()
        binding.aNoteMainText.text = aNoteActivity.noteMainText.toString()
        binding.viewANote.setOnClickListener {
            aNoteActivity.fragmentViewChange(Companion.EDIT_SIGNAL)
        }

        canDeleteANote()
    }

    private fun canDeleteANote() {
        binding.deleteButton.setOnClickListener {
            aNoteActivity.deleteANote(
                ANoteEntity(
                    id = aNoteActivity.noteId,
                    title = aNoteActivity.noteTitle,
                    mainText = aNoteActivity.noteMainText
                )
            )
            aNoteActivity.onBackPressedDispatcher.onBackPressed()
        }
    }

    companion object {
        fun newInstance() = ViewANoteFragment()
        const val EDIT_SIGNAL: Int = 1000000000
    }

}