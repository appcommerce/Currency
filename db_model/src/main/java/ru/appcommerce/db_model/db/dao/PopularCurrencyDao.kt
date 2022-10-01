package ru.appcommerce.db_model.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ru.appcommerce.db_model.model.popular.Currency

@Dao
interface PopularCurrencyDao {
    @Query("SELECT * FROM currency")
    suspend fun getPopularCurrencies(): Currency?

    @Insert
    suspend fun setPopularCurrencies(items: Currency)
}
