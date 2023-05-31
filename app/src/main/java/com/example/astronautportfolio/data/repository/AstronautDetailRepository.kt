package com.example.astronautportfolio.data.repository

import com.example.astronautportfolio.data.local.database.AstronautDatabase
import com.example.astronautportfolio.data.mappers.AstronautDetailMapper
import com.example.astronautportfolio.data.remote.AstronautAPI
import com.example.astronautportfolio.model.detail.AstronautDetail
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class AstronautDetailRepository @Inject constructor(
    private val astronautApi: AstronautAPI,
    private val astronautDb: AstronautDatabase
){
    suspend fun getAstronautDetail(astronautId: Int): AstronautDetail<Any?> {
        try {
            println("masuk get astronaut")
            println("astronaut api: $astronautApi, astronautId: $astronautId")
            var astronautEntity = astronautApi.getAstronautDetailById(astronautId)
            println("astronaut entity: $astronautEntity")
            var astronautDtoToEntity = AstronautDetailMapper().mapAstronautDetailDtoToEntity(astronautEntity)
            astronautDb.selectedAstronautDao().addAstronautDetail(astronautDtoToEntity)
            return AstronautDetailMapper().mapAstronautDetailEntityToModel(astronautDtoToEntity)
        } catch (e: IOException) {
            println("ioe Exception")
            throw e
        } catch(e: HttpException) {
            println("http exception")
            throw e
        }
    }
}