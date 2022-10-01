package ru.appcommerce.popular_feature.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import ru.appcommerce.core_ui.base.BaseViewModel
import ru.appcommerce.core_ui.base.UiState
import ru.appcommerce.db_model.model.popular.CurrencyRate
import ru.appcommerce.popular_feature.domain.interactor.PopularCurrencyInteractor
import javax.inject.Inject

class PopularViewModel(
    savedStateHandle: SavedStateHandle
): BaseViewModel() {

    @Inject
    lateinit var popularCurrencyInteractor: PopularCurrencyInteractor

    private val currencies: MutableLiveData<UiState<List<CurrencyRate>>> = MutableLiveData()

    val _currencies: LiveData<UiState<List<CurrencyRate>>>
        get() = currencies

    private fun reload() {
        makeRequest(currencies) {
            popularCurrencyInteractor.getPopularCurrencies()
        }
    }

    override fun start() {
        reload()
    }

    companion object {
        private const val ARG_SAVED: String = "ARG_SAVED"
    }
}
