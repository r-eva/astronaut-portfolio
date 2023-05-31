package com.example.astronautportfolio.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.room.withTransaction
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

    suspend fun getAstronautById(astronautId: Int): AstronautDetail {
        return try {
            println("astronautApi: $astronautApi")
            val astronaut = astronautApi.getAstronautDetailById(astronautId)
            println("masuk try $astronaut")
            astronautDb.withTransaction {
                val resultEntity = AstronautDetailMapper().mapAstronautDetailDtoToEntity(astronaut)
                astronautDb.selectedAstronautDao().addAstronautDetail(resultEntity)
                AstronautDetailMapper().mapAstronautDetailEntityToModel(resultEntity)
            }
        } catch (e: Exception) {
            val astronaut = astronautDb.selectedAstronautDao().getAstronautDetailById(astronautId)
            if (astronaut == null) {
                throw e
            } else {
                return AstronautDetailMapper().mapAstronautDetailEntityToModel(astronaut)
            }
        }

    }

}