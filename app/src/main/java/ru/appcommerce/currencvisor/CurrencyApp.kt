package ru.appcommerce.currencvisor

import android.app.Application
import ru.appcommerce.currencvisor.di.components.AppComponent
import ru.appcommerce.currencvisor.di.components.DaggerAppComponent
import ru.appcommerce.navigation.di.components.DaggerNavigationComponent
import ru.appcommerce.navigation.di.components.NavigationComponent

private const val APP_COMPONENT_INIT_EXCEPTION = "AppComponent isn't init"

class CurrencyApp: Application() {

    private var _appComponent: AppComponent? = null
    internal val appComponent: AppComponent
    get() = checkNotNull(_appComponent) {
        APP_COMPONENT_INIT_EXCEPTION
    }

    override fun onCreate() {
        super.onCreate()
        _appComponent = DaggerAppComponent
            .builder()
            .application(this)
            .build()
    }

    companion object {
        val navComponent: NavigationComponent by lazy {
            DaggerNavigationComponent.builder()
                .build()
        }
    }

}
