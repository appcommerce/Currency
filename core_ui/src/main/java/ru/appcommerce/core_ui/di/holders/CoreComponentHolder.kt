package ru.appcommerce.core_ui.di.holders

import ru.appcommerce.core_ui.di.components.CoreComponent
import ru.appcommerce.core_ui.di.components.DaggerCoreComponent

object CoreComponentHolder {
    fun inject(): CoreComponent = DaggerCoreComponent.create()
}
