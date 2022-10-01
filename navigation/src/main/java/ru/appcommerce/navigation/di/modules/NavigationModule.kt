package ru.appcommerce.navigation.di.modules

import com.github.terrakok.cicerone.Cicerone
import dagger.Module
import dagger.Provides

@Module
object NavigationModule {
    private val cicerone = Cicerone.create()

    @Provides
    fun provideNavHolder() = cicerone.getNavigatorHolder()

    @Provides
    fun provideAppRouter() = cicerone.router

}
