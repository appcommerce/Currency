package ru.appcommerce.popular_feature.di

import dagger.Binds
import dagger.Module
import ru.appcommerce.popular_feature.data.repository.PopularCurrencyRepositoryImpl
import ru.appcommerce.popular_feature.domain.repository.PopularCurrencyRepository

@Module
interface PopularFeatureBinds {

    @Binds
    fun providePopularRepository(popularRepository: PopularCurrencyRepositoryImpl): PopularCurrencyRepository
}
