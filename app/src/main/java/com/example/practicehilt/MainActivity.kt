package com.example.practicehilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practicehilt.ui.TextFragment
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_container, TextFragment())
                    .commitNow()
        }

    }
}