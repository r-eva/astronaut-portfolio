package com.example.astronautportfolio.data.repository

import com.example.astronautportfolio.data.local.dao.SelectedAstronautDao
import com.example.astronautportfolio.data.local.database.AstronautDatabase
import com.example.astronautportfolio.data.local.entity.detail.AstronautDetailEntity
import com.example.astronautportfolio.data.mappers.AstronautDetailMapper
import com.example.astronautportfolio.data.remote.AstronautAPI
import com.example.astronautportfolio.model.detail.AstronautDetail
import javax.inject.Inject

class AstronautDetailRepository @Inject constructor(
    private val astronautApi: AstronautAPI,
    private val astronautDb: AstronautDatabase,
    private val selectedAstronautDao: SelectedAstronautDao
){
    suspend fun getAstronautDetail(astronautId: Int): AstronautDetail<Any?> {
        try {
            println("enter get astronaut")
            val astronautEntity = astronautApi.getAstronautDetailById(astronautId)
            println("astronautEntity: $astronautEntity")
            val astronautDtoToEntity = AstronautDetailMapper().mapAstronautDetailDtoToEntity(astronautEntity)
            astronautDb.selectedAstronautDao().addAstronautDetail(astronautDtoToEntity)
            return AstronautDetailMapper().mapAstronautDetailEntityToModel(astronautDtoToEntity)
        } catch (e: Exception) {
            val check = astronautDb.selectedAstronautDao().getAllDetail()
            println("check: $check")
            val isAstronautExistOnDb = selectedAstronautDao.getAstronautDetailById(astronautId)
            println("enter catch, astronaut id: $astronautId")
            println("Astronaut exist or not: $isAstronautExistOnDb")
            if (isAstronautExistOnDb.flights.isNullOrEmpty()) {
                println("astronaut not exist in database")
                throw e
            } else {
                println("astronaut exist in database")
                return AstronautDetailMapper().mapAstronautDetailEntityToModel(isAstronautExistOnDb)
            }
        }
    }
}