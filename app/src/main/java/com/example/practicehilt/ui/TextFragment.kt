package com.example.practicehilt.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.practicehilt.databinding.TextFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class TextFragment : Fragment() {

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