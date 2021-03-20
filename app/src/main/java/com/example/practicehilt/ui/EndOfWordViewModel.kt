package com.example.practicehilt.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class EndOfWordViewModel @Inject constructor(): ViewModel(){
    val ordinaryEnding = MutableLiveData("")
    val questionEnding = MutableLiveData("")
}