package com.example.practicehilt.ui

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class TextViewModel @Inject constructor(
    private val viewModel: EndOfWordViewModel
) : ViewModel() {
    val text = MutableLiveData("")

    private val _endingChanged = MutableLiveData("")
    val endingChanged: LiveData<String> = _endingChanged

    fun onButtonClicked() {
        _endingChanged.value = convert(
            text.value ?: return,
            viewModel.ordinaryEnding.value ?: "",
            viewModel.questionEnding.value ?: ""
        )
    }

    fun copyConverted(){
        // TODO: コピーを実装する
    }

    companion object {
        @JvmStatic
        fun convert(original: String, ordinaryEnding: String, questionEnding: String): String {
            var result = ""
            val normalEndingCharList = arrayListOf('。', '!', '！')
            val questionEndingCharList = arrayListOf('?', '？')

            val isPreCharNormal = { index: Int ->
                var value = index > 0
                if (value) {
                    value = value and (original[index - 1] !in normalEndingCharList)
                    value = value and (original[index - 1] !in questionEndingCharList)
                }
                value
            }

            original.forEachIndexed { index, it ->
                if (isPreCharNormal(index)) {
                    if (it in normalEndingCharList)
                        result += ordinaryEnding
                    if (it in questionEndingCharList)
                        result += questionEnding
                }
                result += it
            }
            return result
        }
    }
}