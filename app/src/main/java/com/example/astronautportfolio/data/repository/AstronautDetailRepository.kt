package com.example.astronautportfolio.data.repository

import com.example.astronautportfolio.data.local.dao.AstronautDetailDao
import com.example.astronautportfolio.data.local.database.AstronautDatabase
import com.example.astronautportfolio.data.mappers.AstronautMapper
import com.example.astronautportfolio.data.remote.api.AstronautAPI
import com.example.astronautportfolio.model.detail.AstronautDetail
import javax.inject.Inject

class AstronautDetailRepository @Inject constructor(
    private val astronautApi: AstronautAPI,
    private val astronautDb: AstronautDatabase
){
    suspend fun getAstronautDetail(astronautId: Int): AstronautDetail {
        try {
            println("enter get astronaut")
            val isAstronautExistOnDb = astronautDb.astronautDetailDao().getAstronautDetailById(astronautId)
            if(isAstronautExistOnDb.flights != null) {
                println("astronaut exist on db")
                return AstronautMapper().mapAstronautDetailEntityToModel(isAstronautExistOnDb)
            } else {
                println("try to get astronaut since it is not exist in database")
                val astronautDto = astronautApi.getAstronautDetailById(astronautId)
                println("astronautEntity: $astronautDto")
                val astronautDtoToEntity = AstronautMapper().mapAstronautDetailDtoToEntity(astronautDto)
                astronautDb.astronautDetailDao().addAstronautDetail(astronautDtoToEntity)
                return AstronautMapper().mapAstronautDetailEntityToModel(astronautDtoToEntity)
            }
        } catch (e: Exception) {
            println("astronaut failed geting from api and not exist in database")
            println("error message: $e")
            val isAstronautExistOnDb = astronautDb.astronautDetailDao().getAstronautDetailById(astronautId)
            println("isAstronautExistOnDb: $isAstronautExistOnDb")
            return AstronautMapper().mapAstronautDetailEntityToModel(isAstronautExistOnDb)
        }
    }
}