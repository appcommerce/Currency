package ru.appcommerce.db_model.model.popular

import androidx.room.ColumnInfo
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CurrencyRate(
    @[ColumnInfo(name = "change") Json(name = "change")] val change: Double,
    @[ColumnInfo(name = "change_pct") Json(name = "change_pct")] val changePct: Double,
    @[ColumnInfo(name = "end_rate") Json(name = "end_rate")] val endRate: Double,
    @[ColumnInfo(name = "start_rate") Json(name = "start_rate")] val startRate: Double
)
