package ru.appcommerce.db_model.db.settings

import androidx.room.TypeConverter
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import ru.appcommerce.db_model.model.popular.CurrencyRate

class HashMapDbConverter {

    @TypeConverter
    fun mapToString(rates: Map<String, CurrencyRate>?): String {
        val moshi = Moshi.Builder().build()
        val type = Types.newParameterizedType(
            Map::class.java,
            String::class.java,
            CurrencyRate::class.java
        )
        val jsonAdapter: JsonAdapter<Map<String, CurrencyRate>> = moshi.adapter(type)
        return jsonAdapter.toJson(rates).orEmpty()
    }

    @TypeConverter
    fun toMap(rates: String?): Map<String, CurrencyRate>? {
        val moshi = Moshi.Builder().build()
        val type = Types.newParameterizedType(
            Map::class.java,
            String::class.java,
            CurrencyRate::class.java
        )
        return moshi.adapter<Map<String, CurrencyRate>>(type).fromJson(rates.orEmpty())
    }
}
