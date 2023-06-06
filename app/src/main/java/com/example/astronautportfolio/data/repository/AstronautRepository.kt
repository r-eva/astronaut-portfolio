package com.example.astronautportfolio.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.astronautportfolio.data.local.dao.AstronautDao
import com.example.astronautportfolio.data.remote.api.AstronautAPI
import com.example.astronautportfolio.data.local.database.AstronautDatabase
import com.example.astronautportfolio.data.local.entity.astronaut.overview.AstronautEntity
import com.example.astronautportfolio.data.mappers.AstronautMapper
import com.example.astronautportfolio.data.remote.api.AstronautRemoteMediator
import com.example.astronautportfolio.model.overview.Astronaut
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AstronautRepository @Inject constructor(
    private val astronautApi: AstronautAPI,
    private val astronautDb: AstronautDatabase,
    private val astronautDao: AstronautDao,
) {
    @OptIn(ExperimentalPagingApi::class)
    fun provideAstronautPager(): Flow<PagingData<AstronautEntity>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            remoteMediator = AstronautRemoteMediator(
                astronautDb = astronautDb,
                astronautApi = astronautApi
            ),
            pagingSourceFactory = {
                astronautDb.astronautDao().pagingSource()
            }
        ).flow
    }
}