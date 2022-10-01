package ru.appcommerce.popular_feature.data.api

import retrofit2.http.GET
import ru.appcommerce.db_model.model.popular.Currency

interface CurrencyService {

    @GET("/exchangerates_data/fluctuation")
    suspend fun getCurrencies(): Currency?
}
