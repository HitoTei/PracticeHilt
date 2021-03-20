package com.example.practicehilt.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EndOfWordViewModel @Inject constructor(): ViewModel(){
    val ordinaryEnding = MutableLiveData("")
    val questionEnding = MutableLiveData("")
}