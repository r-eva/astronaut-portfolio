package com.example.astronautportfolio.di

import android.content.Context
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.room.Room
import com.example.astronautportfolio.data.local.database.AstronautDatabase
import com.example.astronautportfolio.data.local.entity.ResultEntity
import com.example.astronautportfolio.data.remote.AstronautRemoteMediator
import com.example.astronautportfolio.data.remote.overview.AstronautAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@OptIn(ExperimentalPagingApi::class)
@Module
@InstallIn(SingletonComponent::class)

object Module {

    @Provides
    @Singleton
    fun provideAstronautDatabase(@ApplicationContext context: Context): AstronautDatabase {
        return Room.databaseBuilder(
            context,
            AstronautDatabase::class.java,
            "astronauts.db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideAstronautApi(): AstronautAPI {
        return Retrofit.Builder()
            .baseUrl(AstronautAPI.BaseURL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideAstronautPager(astronautDb: AstronautDatabase, astronautApi: AstronautAPI): Pager<Int, ResultEntity> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            remoteMediator = AstronautRemoteMediator(
                astronautDb = astronautDb,
                astronautApi = astronautApi
            ),
            pagingSourceFactory = {
                astronautDb.astronautDao().pagingSource()
            }
        )
    }

}