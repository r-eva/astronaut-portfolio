package com.example.astronautportfolio.di

import android.app.Application
import com.example.astronautportfolio.data.local.dao.AstronautDao
import com.example.astronautportfolio.data.local.database.AstronautDatabase
import com.example.astronautportfolio.data.remote.api.AstronautAPI
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
@ExperimentalSerializationApi
object Module {

    @Singleton
    @Provides
    fun provideAstronautDatabase(context: Application): AstronautDatabase {
        return AstronautDatabase.getAppDB(context)
    }

    @Singleton
    @Provides
    fun provideAstronautDao(appDB: AstronautDatabase): AstronautDao {
        return appDB.astronautDao()
    }

    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        val contentType = "application/json".toMediaType()
        val json = Json {
            ignoreUnknownKeys = true
        }

        return Retrofit.Builder()
            .baseUrl(AstronautAPI.BaseURL)
            .client(okHttpClient)
            .addConverterFactory(json.asConverterFactory(contentType))
            .build()
    }

    @Provides
    @Singleton
    fun provideAstronautApi(retrofit: Retrofit): AstronautAPI {
        return retrofit.create(AstronautAPI::class.java)
    }

}