package ru.appcommerce.network.config

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import ru.appcommerce.network.BuildConfig
import javax.inject.Inject

private const val API_HEADER_NAME = "apikey"
class HeaderInterceptor @Inject constructor(): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder().addHeader(
            API_HEADER_NAME, BuildConfig.API_KEY
        ).build()
        return chain.proceed(request)
    }
}
