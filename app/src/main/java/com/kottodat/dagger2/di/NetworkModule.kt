package com.kottodat.dagger2.di

import com.kottodat.dagger2.data.api.OpenWeatherMapApi
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
open class NetworkModule {

    companion object {
        val instance = NetworkModule()
    }

    @Singleton
    @Provides
    @IntoSet
    fun provideNetworkLogger(): Interceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(
        loggingInterceptors: Set<@JvmSuppressWildcards
        Interceptor>
    ):
            OkHttpClient =
        OkHttpClient.Builder().apply {
            loggingInterceptors.forEach {
                addNetworkInterceptor(it)
                addNetworkInterceptor(interceptor)
            }
        }.build()

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://samples.openweathermap.org/data/2.5/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

//            .addConverterFactory(
//                MoshiConverterFactory.create(
//                    Moshi.Builder()
//                        .build()
//                )
//            )
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
//            .build()

    }

    val interceptor: Interceptor = Interceptor { chain: Interceptor.Chain ->
        val original = chain.request()
        var url: HttpUrl = original
            .url()
            .newBuilder()
            .addQueryParameter("APPID", "f05a608df7018dbb5d9c87b9b79ae42a")
            .build()
        val requestBuilder = original.newBuilder().url(url)
        chain.proceed(requestBuilder.build())

    }

    @Singleton
    @Provides
    fun provideOpenWeatherMapApi(retrofit: Retrofit): OpenWeatherMapApi {
        return retrofit.create(OpenWeatherMapApi::class.java)
    }
}