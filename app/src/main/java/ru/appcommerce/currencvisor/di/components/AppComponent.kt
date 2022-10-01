package ru.appcommerce.currencvisor.di.components

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component
@Singleton
interface AppComponent {

    fun getApplication(): Application

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: Application): Builder
        fun build(): AppComponent
    }
}
