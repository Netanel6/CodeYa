package com.netanel.codeya.utils


/**
 * Created by netanelamar on 23/12/2023.
 * NetanelCA2@gmail.com
 */

fun String.digitToWord(): String {
    return when (this) {
        "0" -> "Zero"
        "1" -> "One"
        "2" -> "Two"
        "3" -> "Three"
        "4" -> "Four"
        "5" -> "Five"
        "6" -> "Six"
        "7" -> "Seven"
        "8" -> "Eight"
        "9" -> "Nine"
        else -> throw IllegalArgumentException("Invalid digit: $this")
    }
}