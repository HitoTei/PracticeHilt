package com.example.practicehilt.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class TextViewModel @Inject constructor(): ViewModel() {
    val text = MutableLiveData("")
}