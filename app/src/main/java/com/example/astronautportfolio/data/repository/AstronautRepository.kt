package com.example.astronautportfolio.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.astronautportfolio.data.local.dao.AstronautDao
import com.example.astronautportfolio.data.remote.api.AstronautAPI
import com.example.astronautportfolio.data.local.database.AstronautDatabase
import com.example.astronautportfolio.data.local.entity.astronaut.AstronautEntity
import com.example.astronautportfolio.data.mappers.AstronautMapper
import com.example.astronautportfolio.data.remote.api.AstronautRemoteMediator
import com.example.astronautportfolio.model.Astronaut
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

    suspend fun getAstronautDetail(astronautId: Int): Astronaut {
        try {
            println("enter get astronaut repository")
            val astronautEntity = astronautApi.getAstronautDetailById(astronautId)
            println("astronautEntity: $astronautEntity")
            val astronautDtoToEntity = AstronautMapper().mapAstronautDtoToEntity(astronautEntity)
            /*astronautDb.astronautDao().addAstronautDetail(
                astronautId,
                astronautDtoToEntity.flights,
                astronautDtoToEntity.landings,
                astronautDtoToEntity.spacewalks
            )*/
            return AstronautMapper().mapAstronautEntityToAstronaut(astronautDtoToEntity)
        } catch (e: Exception) {
            val isAstronautFlightExistOnDB = astronautDb.astronautDao().getAstronautDetailById(astronautId).flights
            println("failed fetch database astronaut flight: $isAstronautFlightExistOnDB")
            println("enter catch, astronaut id: $astronautId")
            println("Astronaut exist or not: $isAstronautFlightExistOnDB")
            if (isAstronautFlightExistOnDB!= null) {
                val astronautDetail = astronautDb.astronautDao().getAstronautDetailById(astronautId)
                return AstronautMapper().mapAstronautEntityToAstronaut(astronautDetail)
            }
            println("astronaut not exist in database")
            throw e
        }
    }
}