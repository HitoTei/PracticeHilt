package com.example.practicehilt

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.practicehilt.ui.EndOfWordFragment
import com.example.practicehilt.ui.TextFragment
import com.example.practicehilt.ui.TextViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: TextViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_container, TextFragment())
                .replace(R.id.end_of_word_container, EndOfWordFragment())
                .commitNow()
        }
        getSystemService(Context.CLIPBOARD_SERVICE)
    }
}