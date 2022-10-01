package ru.appcommerce.popular_feature.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import ru.appcommerce.db_model.db.dao.PopularCurrencyDao
import ru.appcommerce.db_model.db.settings.DatabaseBuilder
import ru.appcommerce.popular_feature.data.api.CurrencyService
import javax.inject.Singleton

@Module
object PopularFeatureModule {

    @Provides
    fun provideCurrencyApi(retrofit: Retrofit) = retrofit.create(CurrencyService::class.java)
}
