package com.example.astronautportfolio.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.astronautportfolio.data.remote.AstronautAPI
import com.example.astronautportfolio.data.local.database.AstronautDatabase
import com.example.astronautportfolio.data.local.entity.overview.ResultEntity
import com.example.astronautportfolio.data.mappers.AstronautDetailMapper
import com.example.astronautportfolio.data.remote.AstronautRemoteMediator
import com.example.astronautportfolio.model.detail.AstronautDetail
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AstronautRepository @Inject constructor(
    private val astronautApi: AstronautAPI,
    private val astronautDb: AstronautDatabase,
) {
    @OptIn(ExperimentalPagingApi::class)
    fun provideAstronautPager(): Flow<PagingData<ResultEntity>> {
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