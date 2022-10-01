package ru.appcommerce.network.di

import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import ru.appcommerce.network.BuildConfig
import ru.appcommerce.network.config.HeaderInterceptor

@Module
object NetworkModule {

    @Provides
    fun logInterceptor() = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
        headerInterceptor: HeaderInterceptor
    ): OkHttpClient = OkHttpClient
        .Builder()
        .addInterceptor(loggingInterceptor)
        .addInterceptor(headerInterceptor)
        .build()

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit
        .Builder()
        .baseUrl(BuildConfig.SERVER_URL)
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
}
