package ru.appcommerce.core_ui.utils

import java.text.SimpleDateFormat
import java.util.*

fun String.toDate(simpleDateFormat: SimpleDateFormat) = simpleDateFormat.parse(this)

val formatter: SimpleDateFormat by lazy {
    SimpleDateFormat("yyyy-MM-dd", Locale("ru-Ru"))
}

fun Date?.orToday() = this ?: Date()
