package com.kroman.presentation.utils

import java.text.SimpleDateFormat
import java.util.*

object DateUtils {
    private const val TIMESTAMP_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss"
    private const val DEFAULT_FORMAT_DATE = "dd/MM/yyyy, HH:mm"

    fun formatDate(date: String): String {
        val parser = SimpleDateFormat(TIMESTAMP_DATE_FORMAT, Locale.getDefault())
        val outputFormat = SimpleDateFormat(DEFAULT_FORMAT_DATE, Locale.getDefault())
        return outputFormat.format(parser.parse(date)!!)
    }
}