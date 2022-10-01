package ru.appcommerce.popular_feature.domain.repository

import ru.appcommerce.db_model.model.popular.CurrencyRate

interface PopularCurrencyRepository {

    suspend fun getCurrencies(): List<CurrencyRate>
}
