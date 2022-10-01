package ru.appcommerce.navigation.di.components

import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.Component
import ru.appcommerce.navigation.di.modules.NavigationModule

@Component(modules = [NavigationModule::class])
interface NavigationComponent {
    fun getRouter(): Router
    fun getNavigatorHolder(): NavigatorHolder
}
