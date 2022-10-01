package ru.appcommerce.popular_feature.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.appcommerce.core_ui.utils.formatter
import ru.appcommerce.core_ui.utils.orToday
import ru.appcommerce.core_ui.utils.toDate
import ru.appcommerce.db_model.db.dao.PopularCurrencyDao
import ru.appcommerce.db_model.model.popular.CurrencyRate
import ru.appcommerce.db_model.model.popular.toRateList
import ru.appcommerce.popular_feature.data.api.CurrencyService
import ru.appcommerce.popular_feature.domain.repository.PopularCurrencyRepository
import javax.inject.Inject

class PopularCurrencyRepositoryImpl @Inject constructor(
    private val currencyService: CurrencyService,
    private val popularCurrencyDao: PopularCurrencyDao
): PopularCurrencyRepository {

    override suspend fun getCurrencies(): List<CurrencyRate> {
        return withContext(Dispatchers.IO) {
            val oldCache = popularCurrencyDao.getPopularCurrencies()
            val itemFromNetwork = currencyService
                .getCurrencies() ?: return@withContext oldCache.toRateList()
            val actualDate = itemFromNetwork.startDate.toDate(formatter).orToday()
            val savedDate = oldCache?.startDate?.toDate(formatter)
            if (oldCache == null || actualDate.after(savedDate)) {
                popularCurrencyDao.setPopularCurrencies(itemFromNetwork)
            }
            val newCache = popularCurrencyDao.getPopularCurrencies()
            return@withContext newCache.toRateList()
        }
    }
}
