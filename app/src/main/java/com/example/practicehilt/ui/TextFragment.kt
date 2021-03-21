package com.example.practicehilt.ui

import android.content.ClipData
import android.content.ClipboardManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
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
        binding.convertedText.setOnLongClickListener {
            val activity = this.requireActivity()
            Toast.makeText(activity, "コピーしました", Toast.LENGTH_SHORT).show()
            val clipboard = getSystemService(
                activity,
                ClipboardManager::class.java
            )
            val clip: ClipData = ClipData.newPlainText("simple text", viewModel.endingChanged.value)
            clipboard?.setPrimaryClip(clip)
            true
        }
        return binding.root
    }

}