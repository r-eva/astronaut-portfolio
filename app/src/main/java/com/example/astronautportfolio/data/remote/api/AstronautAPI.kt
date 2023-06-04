package com.example.astronautportfolio.data.remote.api

import com.example.astronautportfolio.data.remote.dto.AstronautDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AstronautAPI {
    @GET("astronaut/")
    suspend fun getAstronauts(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int?
    ): AstronautsApiResponseDto

    @GET("astronaut/{id}")
    suspend fun getAstronautDetailById(
        @Path("id") id: Int
    ): AstronautDto

    companion object {
        const val BaseURL = "https://ll.thespacedevs.com/2.2.0/"
    }
}

