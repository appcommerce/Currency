package ru.appcommerce.db_model.db.settings

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.appcommerce.db_model.db.dao.PopularCurrencyDao
import ru.appcommerce.db_model.model.popular.Currency

@Database(version = 1, exportSchema = false, entities = [Currency::class])
@TypeConverters(HashMapDbConverter::class)
abstract class DatabaseBuilder: RoomDatabase() {
    abstract fun getPopularDao(): PopularCurrencyDao
}
