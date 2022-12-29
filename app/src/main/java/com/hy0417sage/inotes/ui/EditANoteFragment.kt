package com.hy0417sage.inotes.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hy0417sage.inotes.ANoteActivity
import com.hy0417sage.inotes.databinding.FragmentEditANoteBinding
import com.hy0417sage.inotes.repository.data.ANoteEntity

class EditANoteFragment : Fragment() {

    lateinit var aNoteActivity: ANoteActivity
    lateinit var binding: FragmentEditANoteBinding

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

        binding.button.setOnClickListener {
            aNoteActivity.insertANote(
                ANoteEntity(
                    null,
                    null,
                    binding.textView.text.toString()
                )
            )
            aNoteActivity.onBackPressed()
        }

    }

    companion object {
        fun newInstance() = EditANoteFragment()
    }
}