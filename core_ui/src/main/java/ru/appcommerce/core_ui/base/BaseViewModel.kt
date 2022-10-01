package ru.appcommerce.core_ui.base

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

abstract class BaseViewModel: ViewModel() {

    abstract fun start()

    fun <R> makeRequest(
        container: MutableLiveData<UiState<R>>,
        apiCall: suspend () -> R
    ) {
        container.value = UiState.Loading
        viewModelScope.launch(
            CoroutineExceptionHandler { _, throwable ->
                Log.d(BaseViewModel::class.java.simpleName, throwable.localizedMessage.orEmpty())
                container.value = UiState.Error(throwable)
            }
        ) {
            when (val response = apiCall.invoke()) {
                is List<*> -> {
                    if (response.isEmpty()) {
                        container.value = UiState.EmptyData
                    } else {
                        container.value = UiState.Data(response)
                    }
                }
                else -> container.value = UiState.Data(response)
            }
        }
    }
}
