package com.example.practicehilt.ui

import android.widget.TextView
import androidx.lifecycle.Observer
import org.junit.Assert
import org.junit.Assert.assertThat
import org.junit.Test

@Suppress("NonAsciiCharacters")
class ConvertTest {


    @Test
    fun 一言の語尾を変えられるか() {
        val actual = TextViewModel.convert("楽しい。", "でやんす", "でやんすか")
        Assert.assertEquals("楽しいでやんす。", actual)
    }

    @Test
    fun 単純な文章の語尾を変えられるか() {
        val actual = TextViewModel.convert("怒った。君は決して踏んではならない虎の尾を踏んでしまった。", "でやんす", "でやんすか")
        Assert.assertEquals("怒ったでやんす。君は決して踏んではならない虎の尾を踏んでしまったでやんす。", actual)
    }

    @Test
    fun 最後の文字が句点ではない文章を変換できるか() {
        val actual = TextViewModel.convert("あ、そう？それならいいけどね！(笑)", "でやんす", "でやんすか")
        Assert.assertEquals("あ、そうでやんすか？それならいいけどねでやんす！(笑)", actual)
    }

    @Test
    fun 感嘆符や疑問符が沢山ある文章を変換できるか() {
        val actual = TextViewModel.convert("貴様！！！！！やってはいけないことをした！！!!！！", "でやんす", "でやんすか")
        Assert.assertEquals("貴様でやんす！！！！！やってはいけないことをしたでやんす！！!!！！", actual)
    }

}