package com.example.practicehilt.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.practicehilt.databinding.EndOfWordFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class EndOfWordFragment : Fragment() {
    @Inject
    lateinit var viewModel: EndOfWordViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = EndOfWordFragmentBinding.inflate(inflater, container, false).apply {
            viewModel = this@EndOfWordFragment.viewModel
            lifecycleOwner = requireActivity()
        }
        return binding.root
    }

}