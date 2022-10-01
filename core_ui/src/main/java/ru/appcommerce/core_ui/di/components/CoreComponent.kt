package ru.appcommerce.core_ui.di.components

import dagger.Component
import ru.appcommerce.core_ui.di.modules.ViewModelFactoryModule

@Component(modules = [ViewModelFactoryModule::class])
interface CoreComponent
