package ru.appcommerce.network.di

import android.content.Context

object DataSourceHolder {
    fun inject(context: Context): NetworkComponent = DaggerNetworkComponent.builder()
        .context(context)
        .build()
}
