package ru.appcommerce.core_ui.base

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

sealed class UiState<out D>: Parcelable {
    @Parcelize
    object Loading: UiState<Nothing>(), Parcelable
    @Parcelize
    object EmptyData: UiState<Nothing>(), Parcelable
    @Parcelize
    data class Data<out D>(val data: @RawValue D): UiState<D>(), Parcelable
    @Parcelize
    data class Error(val error: Throwable): UiState<Nothing>(), Parcelable
}
