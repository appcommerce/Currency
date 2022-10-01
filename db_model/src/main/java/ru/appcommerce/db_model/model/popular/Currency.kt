package ru.appcommerce.db_model.model.popular

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity(tableName = "currency", indices = [Index("id", unique = true)])
@JsonClass(generateAdapter = true)
data class Currency(
    @[PrimaryKey(autoGenerate = true) Json(ignore = true)] val id: Int = 0,
    @Json(name = "base") val base: String,
    @Json(name = "end_date") val endDate: String,
    @Json(name = "fluctuation") val fluctuation: Boolean,
    @Json(name = "rates")
    val rates: Map<String, CurrencyRate>,
    @Json(name = "start_date") val startDate: String
)

fun Currency?.toRateList(): List<CurrencyRate> = this?.rates
    ?.values
    ?.toList()
    .orEmpty()
