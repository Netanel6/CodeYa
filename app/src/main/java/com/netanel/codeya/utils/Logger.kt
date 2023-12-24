package com.netanel.codeya.utils

import android.util.Log


/**
 * Created by netanelamar on 23/12/2023.
 * NetanelCA2@gmail.com
 */
object Logger {

    fun info(tag: String = "info", message: String = "message") {
        Log.i(tag, message)
    }
}