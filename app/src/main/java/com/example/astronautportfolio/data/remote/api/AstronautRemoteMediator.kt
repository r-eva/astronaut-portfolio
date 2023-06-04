package com.example.astronautportfolio.data.remote.api

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.example.astronautportfolio.data.local.database.AstronautDatabase
import com.example.astronautportfolio.data.local.entity.astronaut.AstronautEntity
import com.example.astronautportfolio.data.local.entity.paging.PagingRemoteKeysEntity
import com.example.astronautportfolio.data.mappers.AstronautMapper
import retrofit2.HttpException
import java.io.IOException


@OptIn(ExperimentalPagingApi::class)
class AstronautRemoteMediator (
    private val astronautDb: AstronautDatabase,
    private val astronautApi: AstronautAPI
        ): RemoteMediator <Int, AstronautEntity>() {

    private val pagingRemoteKeysDao = astronautDb.pagingRemoteKeysDao()
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, AstronautEntity>
    ): MediatorResult {
        return try {
            val currentPage = when (loadType) {
                LoadType.REFRESH -> {
                    val remoteKeys = getRemoteKeyClosestToCurrentPosition(state)
                    remoteKeys?.nextPage?.minus(1)?: 0
                }
                LoadType.PREPEND -> {
                    val remoteKeys = getRemoteKeyForFirstItem(state)
                    val prevPage = remoteKeys?.prevPage
                        ?: return MediatorResult.Success(
                            endOfPaginationReached = remoteKeys != null
                        )
                    prevPage
                }
                LoadType.APPEND -> {
                    val remoteKeys = getRemoteKeyForLastItem(state)
                    val nextPage = remoteKeys?.nextPage
                        ?: return MediatorResult.Success(
                            endOfPaginationReached = remoteKeys != null
                        )
                    nextPage
                }
            }

            println("mau manggil database lagi")

            val astronauts = astronautApi.getAstronauts(
                limit = state.config.pageSize,
                offset = currentPage
            )

            println("selesai manggil database")

            val endOfPaginationReached = astronauts.results.isEmpty()

            val prevPage = if (currentPage == 0) null else currentPage - 10
            val nextPage = if (endOfPaginationReached) null else currentPage + 10

            astronautDb.withTransaction {
                println("masukin data ke database")
                if(loadType == LoadType.REFRESH) {
                    astronautDb.astronautDao().clearAll()
                    pagingRemoteKeysDao.deleteAllRemoteKeys()
                }

                val keys = astronauts.results.map { astronautItem ->
                    PagingRemoteKeysEntity(
                        id = astronautItem.id,
                        prevPage = prevPage,
                        nextPage = nextPage
                    )
                }

                pagingRemoteKeysDao.addAllRemoteKeys(remoteKeys = keys)

                val astronautEntity = astronauts.results.map { AstronautMapper().mapAstronautDtoToEntity(it) }
                astronautDb.astronautDao().upsertAll(astronautEntity)
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

    private suspend fun getRemoteKeyClosestToCurrentPosition(
        state: PagingState<Int, AstronautEntity>
    ): PagingRemoteKeysEntity? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.id?.let { id ->
                pagingRemoteKeysDao.getRemoteKeys(id = id)
            }
        }
    }

    private suspend fun getRemoteKeyForFirstItem(
        state: PagingState<Int, AstronautEntity>
    ): PagingRemoteKeysEntity? {
        return state.pages.firstOrNull { it.data.isNotEmpty() }?.data?.firstOrNull()
            ?.let { unsplashImage ->
                pagingRemoteKeysDao.getRemoteKeys(id = unsplashImage.id)
            }
    }

    private suspend fun getRemoteKeyForLastItem(
        state: PagingState<Int, AstronautEntity>
    ): PagingRemoteKeysEntity? {
        return state.pages.lastOrNull { it.data.isNotEmpty() }?.data?.lastOrNull()
            ?.let { unsplashImage ->
                pagingRemoteKeysDao.getRemoteKeys(id = unsplashImage.id)
            }
    }


}