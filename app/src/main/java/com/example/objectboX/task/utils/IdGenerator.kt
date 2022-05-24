package com.example.objectboX.task.utils

import com.example.objectboX.task.utils.Base64.toBase64
import java.util.*

object IdGenerator {
    private const val TAG = "IDGenerator"

    /**
     * Generate new ID
     * @return an Unique ID
     */
    fun getNewId() = "${toBase64(System.currentTimeMillis())}@${toBase64(Random().nextInt(1000).toLong())}"

    // 100% unique in a 24h.
    fun getShortID(): Int {
        val calendar = Calendar.getInstance()
        val h = calendar[Calendar.HOUR_OF_DAY].toString()
        val m = calendar[Calendar.MINUTE].toString()
        val s = calendar[Calendar.SECOND].toString()
        val mm = calendar[Calendar.MILLISECOND].toString()
        val uID = h + m + s + mm
        return uID.toInt() // 100% unique in a 24h.
    }
}