package com.netanel.codeya.utils

import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.IOException


/**
 * Created by netanelamar on 22/12/2023.
 * NetanelCA2@gmail.com
 */


    @Throws(IOException::class)
    fun File.readFileToString(): String {
        val stringBuilder = StringBuilder()
        var bufferedReader: BufferedReader? = null
        try {
            bufferedReader = BufferedReader(FileReader(this))
            var line: String?
            while (bufferedReader.readLine().also { line = it } != null) {
                stringBuilder.append(line).append("\n")
            }
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }
        return stringBuilder.toString()
    }