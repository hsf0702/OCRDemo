package com.example.ocrdemo

import android.content.Context

import java.io.File

/**
 * created by hsf
 * date:2019/12/6
 * description:
 */
object FileUtil {
    fun getSaveFile(context: Context): File {
        return File(context.filesDir, "pic.jpg")
    }
}

