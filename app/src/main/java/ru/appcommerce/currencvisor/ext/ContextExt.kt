package ru.appcommerce.currencvisor.ext

import android.content.Context
import ru.appcommerce.currencvisor.CurrencyApp
import ru.appcommerce.currencvisor.di.components.AppComponent

val Context.appComponent: AppComponent
    get() = when (this) {
        is CurrencyApp -> appComponent
        else -> applicationContext.appComponent
    }
