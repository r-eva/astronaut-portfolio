package com.example.astronautportfolio.data.repository

import com.example.astronautportfolio.data.remote.AstronautAPI
import com.example.astronautportfolio.AstronautsApp
import com.example.astronautportfolio.data.local.dao.AstronautDao
import com.example.astronautportfolio.data.local.dao.SelectedAstronautDao
import com.example.astronautportfolio.data.mappers.AstronautDetailMapper
import com.example.astronautportfolio.di.Module_ProvideAstronautApiFactory
import com.example.astronautportfolio.model.detail.AstronautDetail
import retrofit2.Retrofit

class AstronautRepository(
    private val apiService: AstronautAPI = AstronautsApp.apiService,
    private val astronautDetailDao: SelectedAstronautDao = AstronautsApp.database.selectedAstronautDao(),
    private val astronautMapper: AstronautDetailMapper = AstronautDetailMapper()
) {
    suspend fun getAstronautById(astronautId: Int): AstronautDetail {
        try {
            val astronaut = astronautDetailDao.getAstronautDetailById(astronautId)
            if (astronaut == null || astronaut.flights.isNullOrEmpty()) {
                val response = apiService.getAstronautDetailById(astronautId)
                val astronautEntity = astronautMapper.mapAstronautDetailDtoToEntity(response)
                astronautDetailDao.addAstronautDetail(astronautEntity)
                return astronautMapper.mapAstronautDetailEntityToModel(astronautEntity)
            } else {
                return astronautMapper.mapAstronautDetailEntityToModel(astronaut)
            }
        } catch (e: Exception) {
            val astronaut = astronautDetailDao.getAstronautDetailById(astronautId)
            if (astronaut == null) {
                throw e
            } else {
                return astronautMapper.mapAstronautDetailEntityToModel(astronaut)
            }
        }
    }
}