package com.hy0417sage.inotes.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.hy0417sage.inotes.ANoteActivity
import com.hy0417sage.inotes.databinding.FragmentEditANoteBinding
import com.hy0417sage.inotes.repository.data.ANoteEntity

class EditANoteFragment : Fragment() {

    private lateinit var aNoteActivity: ANoteActivity
    private lateinit var binding: FragmentEditANoteBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ANoteActivity) aNoteActivity = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditANoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkNoteExists(aNoteActivity.noteId)
    }

    private fun checkNoteExists(id: Int) {
        when (id) {
            -1 -> insertANote()
            else -> {
                binding.titleEdit.setText(aNoteActivity.noteTitle.toString())
                binding.mainTextEdit.setText(aNoteActivity.noteMainText.toString())
                insertANote(id = aNoteActivity.noteId)
            }
        }
    }

    private fun insertANote(id: Int? = null) {
        binding.insertNote.setOnClickListener {
            val title = binding.titleEdit.text.toString()
            val mainText = binding.mainTextEdit.text.toString()
            if (title.isNotEmpty() || mainText.isNotEmpty()) {
                when (id) {
                    null -> {
                        aNoteActivity.insertANote(
                            aNoteEntity(id, title, mainText)
                        )
                        aNoteActivity.onBackPressedDispatcher.onBackPressed()
                    }
                    else -> {
                        aNoteActivity.updateANote(
                            aNoteEntity(id, title, mainText)
                        )
                        aNoteActivity.changeNote(title, mainText)
                        aNoteActivity.fragmentViewChange(id)
                    }
                }
            }else{
                val toast = Toast.makeText(aNoteActivity,"note is empty\n can't save (｡•́︿•̀｡)", Toast.LENGTH_SHORT)
                toast.show()
            }
        }
    }

    fun aNoteEntity(id: Int?, title: String, mainText: String): ANoteEntity {
        return ANoteEntity(
            id,
            title,
            mainText
        )
    }

    companion object {
        fun newInstance() = EditANoteFragment()
    }
}