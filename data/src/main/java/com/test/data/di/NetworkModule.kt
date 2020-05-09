package com.test.data.di

import android.content.Context
import com.test.data.BuildConfig
import com.test.data.service.JsonPlaceholderService
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetworkModule {
    companion object {
        private const val CONNECT_TIMEOUT = 15
        private const val WRITE_TIMEOUT = 15
        private const val READ_TIMEOUT = 15
    }

    @Provides
    @Singleton
    fun provideOkHttpCache(application: Context): Cache {
        val cacheSize = 10 * 1024 * 1024 // 10MB
        return Cache(application.cacheDir, cacheSize.toLong())
    }

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

    @Provides
    @Singleton
    fun provideOkHttpClient(cache: Cache, httpLoggingInterceptor: HttpLoggingInterceptor) = OkHttpClient.Builder().apply {
        cache(cache)
        connectTimeout(CONNECT_TIMEOUT.toLong(), TimeUnit.SECONDS)
        writeTimeout(WRITE_TIMEOUT.toLong(), TimeUnit.SECONDS)
        readTimeout(READ_TIMEOUT.toLong(), TimeUnit.SECONDS)
        addInterceptor(httpLoggingInterceptor)
    }.build()

    @Provides
    @Singleton
    @Named("JsonPlaceholderService")
    fun retrofitJsonPlaceholderService(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder().apply {
            client(okHttpClient)
            baseUrl(BuildConfig.API_URL)
            addConverterFactory(GsonConverterFactory.create())
    }.build()

    @Provides
    @Singleton
    fun provideJsonPlaceholderService(@Named("JsonPlaceholderService")retrofit: Retrofit): JsonPlaceholderService {
        return retrofit.create(JsonPlaceholderService::class.java)
    }
}
