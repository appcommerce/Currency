package ru.appcommerce.popular_feature.di

import dagger.Component
import retrofit2.Retrofit
import ru.appcommerce.core_ui.di.components.CoreComponent
import ru.appcommerce.core_ui.di.scopes.FeatureScope
import ru.appcommerce.network.di.NetworkComponent
import ru.appcommerce.popular_feature.presentation.PopularViewModel

@Component(
    modules = [
        PopularFeatureBinds::class,
        PopularFeatureModule::class
    ],
    dependencies = [
        NetworkComponent::class,
        CoreComponent::class
    ]
)
@FeatureScope
interface PopularFeatureComponent {

    val retrofit: Retrofit

    fun inject(popularViewModel: PopularViewModel)

    @Component.Builder
    interface Builder {
        fun networkComponent(networkComponent: NetworkComponent): Builder
        fun coreComponent(coreComponent: CoreComponent): Builder
        fun build(): PopularFeatureComponent
    }
}
