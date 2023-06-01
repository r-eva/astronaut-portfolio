package com.example.astronautportfolio.di

import android.content.Context
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.room.Room
import com.example.astronautportfolio.data.local.database.AstronautDatabase
import com.example.astronautportfolio.data.local.entity.overview.ResultEntity
import com.example.astronautportfolio.data.mappers.AstronautDetailMapper
import com.example.astronautportfolio.data.remote.AstronautRemoteMediator
import com.example.astronautportfolio.data.remote.AstronautAPI
import com.example.astronautportfolio.model.detail.AstronautDetail
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.buildJsonArray
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@OptIn(ExperimentalPagingApi::class)
@Module
@InstallIn(SingletonComponent::class)
@ExperimentalSerializationApi
object Module {

    @Provides
    @Singleton
    fun provideAstronautDatabase(@ApplicationContext context: Context): AstronautDatabase {
        return Room.databaseBuilder(
            context,
            AstronautDatabase::class.java,
            "astronauts.db"
        ).allowMainThreadQueries().build()
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