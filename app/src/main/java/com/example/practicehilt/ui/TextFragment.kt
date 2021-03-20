package com.example.practicehilt.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.practicehilt.R
import com.example.practicehilt.databinding.TextFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class TextFragment @Inject constructor() : Fragment() {

    companion object {
        fun newInstance() = TextFragment()
    }

    @Inject
    lateinit var viewModel: TextViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = TextFragmentBinding.inflate(inflater, container, false).apply {
            viewModel = this@TextFragment.viewModel
            lifecycleOwner = requireActivity()
        }
        return binding.root
    }

}