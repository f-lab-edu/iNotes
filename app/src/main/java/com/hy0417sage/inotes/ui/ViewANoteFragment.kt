package com.hy0417sage.inotes.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hy0417sage.inotes.R
import com.hy0417sage.inotes.viewmodel.NotesViewModel

class ViewANoteFragment : Fragment() {

    companion object {
        fun newInstance() = ViewANoteFragment()
    }

    private lateinit var viewModel: NotesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_view_a_note, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(NotesViewModel::class.java)
//        // TODO: Use the ViewModel
    }

}