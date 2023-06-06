package com.example.astronautportfolio.data.repository

import com.example.astronautportfolio.data.local.database.AstronautDatabase
import com.example.astronautportfolio.data.mappers.AstronautMapper
import com.example.astronautportfolio.data.remote.api.AstronautAPI
import com.example.astronautportfolio.model.detail.AstronautDetail
import javax.inject.Inject

class AstronautDetailRepository @Inject constructor(
    private val astronautApi: AstronautAPI,
    private val astronautDb: AstronautDatabase
){
    suspend fun getAstronautDetail(astronautId: Int): AstronautDetail? {
        try {
            println("try to get astronaut from api")
            val astronautDto = astronautApi.getAstronautDetailById(astronautId)
            println("astronautEntity: $astronautDto")
            val astronautDtoToEntity = AstronautMapper().mapAstronautDetailDtoToEntity(astronautDto)
            astronautDb.astronautDetailDao().addAstronautDetail(astronautDtoToEntity)
            return AstronautMapper().mapAstronautDetailEntityToModel(astronautDtoToEntity)
        } catch (e: Exception) {
            val isAstronautExistOnDb = astronautDb.astronautDetailDao().getAstronautDetailById(astronautId)
            println("is astronaut exist on db: $isAstronautExistOnDb")
            return if(isAstronautExistOnDb.flights != null) {
                println("astronaut exist on db")
                AstronautMapper().mapAstronautDetailEntityToModel(isAstronautExistOnDb)
            } else {
                throw e
            }

        }
    }
}