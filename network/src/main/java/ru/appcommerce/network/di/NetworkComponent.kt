package ru.appcommerce.network.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import retrofit2.Retrofit
import ru.appcommerce.db_model.db.dao.PopularCurrencyDao
import ru.appcommerce.db_model.db.settings.DatabaseBuilder
import javax.inject.Singleton

@Component(
    modules = [
        NetworkModule::class,
        CacheModule::class
    ]
)
@Singleton
interface NetworkComponent {

    fun getContext(): Context
    fun getRetrofit(): Retrofit
    fun getPopularDao(): PopularCurrencyDao

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder
        fun build(): NetworkComponent
    }

}
