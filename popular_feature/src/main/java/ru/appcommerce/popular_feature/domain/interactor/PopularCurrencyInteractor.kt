package ru.appcommerce.popular_feature.domain.interactor

import ru.appcommerce.db_model.model.popular.CurrencyRate
import ru.appcommerce.popular_feature.domain.repository.PopularCurrencyRepository
import javax.inject.Inject

class PopularCurrencyInteractor @Inject constructor(
    private val popularCurrencyRepository: PopularCurrencyRepository
) {
    suspend fun getPopularCurrencies(): List<CurrencyRate> =
        popularCurrencyRepository.getCurrencies()


}
