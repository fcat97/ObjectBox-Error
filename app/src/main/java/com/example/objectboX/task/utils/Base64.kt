package com.example.objectboX.task.utils

/**
 * This class provides advantage over java Base
 * is that output string encoded with this class
 * can be used as file names if needed.
 *
 * @author fCat97
 */
object Base64 {
    fun toBase64(x: Long): String = encode(x)

    private fun encode(x: Long): String {
        var base64 = ""
        val c = getChar((x % 64).toInt())
        if ( (x / 64) != 0L) base64 += encode(x/64)
        return base64 + c
    }

    private fun getChar(x: Int): Char {
        return when (x) {
            in 0..25 -> { (x + 65).toChar() }
            in 26..51 -> { (x + 71).toChar() }
            in 52..61 -> { (x - 4).toChar() }
            62 -> { (43).toChar() }
            else -> (47).toChar()
        }
    }
}