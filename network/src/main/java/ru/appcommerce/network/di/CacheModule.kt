package ru.appcommerce.network.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import ru.appcommerce.db_model.db.dao.PopularCurrencyDao
import ru.appcommerce.db_model.db.settings.DatabaseBuilder
import javax.inject.Singleton

@Module
object CacheModule {

    @Provides
    @Singleton
    fun provideRoom(context: Context): DatabaseBuilder {
        return Room
            .databaseBuilder(context, DatabaseBuilder::class.java, "app_currency_db")
            .build()
    }

    @Provides
    @Singleton
    fun providePopularDao(databaseBuilder: DatabaseBuilder): PopularCurrencyDao {
        return databaseBuilder.getPopularDao()
    }
}
