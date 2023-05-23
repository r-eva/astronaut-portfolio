package com.example.astronautportfolio.data.remote

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.example.astronautportfolio.data.local.database.AstronautDatabase
import com.example.astronautportfolio.data.local.entity.ResultEntity
import com.example.astronautportfolio.data.mappers.AstronautMapper
import com.example.astronautportfolio.data.remote.overview.AstronautAPI
import retrofit2.HttpException
import java.io.IOException


@OptIn(ExperimentalPagingApi::class)
class AstronautRemoteMediator (
    private val astronautDb: AstronautDatabase,
    private val astronautApi: AstronautAPI
        ): RemoteMediator <Int, ResultEntity>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, ResultEntity>
    ): MediatorResult {
        return try {
            val loadKey = when (loadType) {
                LoadType.REFRESH -> 0
                LoadType.PREPEND -> return MediatorResult.Success(
                    endOfPaginationReached = true
                )
                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()
                    if(lastItem == null) {
                        0
                    } else {
                        state.config.pageSize + 10
                    }
                }
            }
            val astronauts = astronautApi.getAstronauts(
                limit = loadKey,
                offset = loadKey
            )

            astronautDb.withTransaction {
                if(loadType == LoadType.REFRESH) {
                    astronautDb.astronautDao().clearAll()
                }
                val resultEntity = astronauts.results.map { AstronautMapper().mapResultDtoToEntity(it)
                }
                astronautDb.astronautDao().upsertAll(resultEntity)
            }

            MediatorResult.Success(
                endOfPaginationReached = astronauts.next.isNullOrBlank()
            )

        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch(e: HttpException) {
            MediatorResult.Error(e)
        }
    }
}