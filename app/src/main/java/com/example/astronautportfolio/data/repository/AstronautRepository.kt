package com.example.astronautportfolio.data.repository

import androidx.lifecycle.viewModelScope
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.astronautportfolio.data.remote.api.AstronautAPI
import com.example.astronautportfolio.data.local.database.AstronautDatabase
import com.example.astronautportfolio.data.local.entity.astronaut.AstronautEntity
import com.example.astronautportfolio.data.mappers.AstronautMapper
import com.example.astronautportfolio.data.remote.api.AstronautRemoteMediator
import com.example.astronautportfolio.model.Astronaut
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AstronautRepository @Inject constructor(
    private val astronautApi: AstronautAPI,
    private val astronautDb: AstronautDatabase,
) {
    @OptIn(ExperimentalPagingApi::class)
    fun provideAstronautPager(): Flow<PagingData<Astronaut>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            remoteMediator = AstronautRemoteMediator(
                astronautDb = astronautDb,
                astronautApi = astronautApi
            ),
            pagingSourceFactory = {
                astronautDb.astronautDao().pagingSource()
            }
        ).flow.map { pagingData ->
            pagingData.map {
                AstronautMapper().mapAstronautEntityToAstronaut(it)
            }
        }
    }

    suspend fun getAstronautDetail(astronautId: Int): Astronaut {
        try {
            println("try to get astronaut from api")
            val astronautDto = astronautApi.getAstronautDetailById(astronautId)
            println("astronautEntity: $astronautDto")
            val astronautDtoToEntity = AstronautMapper().mapAstronautDtoToEntity(astronautDto)
            astronautDb.astronautDao().addAstronautDetail(
                astronautId = astronautId,
                astronautFlight = astronautDtoToEntity.flights,
                astronautLanding = astronautDtoToEntity.landings,
                astronautSpacewalk = astronautDtoToEntity.spacewalks
            )
            return AstronautMapper().mapAstronautEntityToAstronaut(astronautDtoToEntity)
        } catch (e: Exception) {
            val isAstronautExistOnDb = astronautDb.astronautDao().getAstronautDetailById(astronautId)
            println("is astronautDetail exist on db: ${isAstronautExistOnDb.flights}")
            return if(isAstronautExistOnDb.flights != null) {
                println("astronaut exist on db")
                AstronautMapper().mapAstronautEntityToAstronaut(isAstronautExistOnDb)
            } else {
                throw e
            }

        }
    }
}