package ru.appcommerce.currencvisor.di.components

import dagger.Component
import ru.appcommerce.core_ui.di.components.CoreComponent
import ru.appcommerce.currencvisor.di.modules.MainModule
import ru.appcommerce.core_ui.di.scopes.ActivityScope
import ru.appcommerce.currencvisor.presentation.MainActivity
import ru.appcommerce.currencvisor.presentation.MainViewModel
import ru.appcommerce.navigation.di.components.NavigationComponent

@Component(
    modules = [
        MainModule::class
    ],
    dependencies = [
        NavigationComponent::class,
        CoreComponent::class
    ]
)
@ActivityScope
interface MainComponent {

    fun inject(activity: MainActivity)
    fun inject(mainViewModel: MainViewModel)

    @Component.Builder
    interface Builder {
        fun navComponent(navComponent: NavigationComponent): Builder
        fun coreComponent(coreComponent: CoreComponent): Builder
        fun build(): MainComponent
    }
}
