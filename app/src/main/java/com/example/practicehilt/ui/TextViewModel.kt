package com.example.practicehilt.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TextViewModel @Inject constructor(
    private val viewModel: EndOfWordViewModel
) : ViewModel() {
    val text = MutableLiveData("")

    private val _endingChanged = MutableLiveData("")
    val endingChanged: LiveData<String> = _endingChanged


    fun covert() {
        _endingChanged.value = changeEnding(
            text.value ?: return,
            viewModel.ordinaryEnding.value ?: "",
            viewModel.questionEnding.value ?: ""
        )
    }

    companion object {
        @JvmStatic
        fun changeEnding(original: String, ordinaryEnding: String, questionEnding: String): String {
            if (original.isEmpty()) return ""
            var result = ""
            val ordinaryEndingCharList =
                arrayListOf(
                    '。',
                    '!',
                    '！',
                    '」',
                    '…',
                    '\n',
                    '　',
                    '（',
                    '(',
                    ')',
                    '）',
                    '「',
                    '『',
                    '」',
                    '』',
                    '【',
                    '】',
                    '.',
                )
            val questionEndingCharList = arrayListOf('?', '？')
            val ordinaryEndingList = ordinaryEnding.split(' ')
            val questionEndingList = questionEnding.split(' ')

            val isPreCharNormal = { index: Int ->
                var value = index > 0
                if (value) {
                    value = value and (original[index - 1] !in ordinaryEndingCharList)
                    value = value and (original[index - 1] !in questionEndingCharList)
                }
                value
            }

            original.forEachIndexed { index, it ->
                if (isPreCharNormal(index)) {
                    if (it in ordinaryEndingCharList)
                        result += ordinaryEndingList.random()
                    if (it in questionEndingCharList)
                        result += questionEndingList.random()
                }
                result += it
            }
            val lastChar = original[original.lastIndex]
            if (lastChar !in ordinaryEndingCharList && lastChar !in questionEndingCharList)
                result += ordinaryEndingList.random()
            return result
        }
    }
}