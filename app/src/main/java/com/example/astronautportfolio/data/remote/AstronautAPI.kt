package com.example.astronautportfolio.data.remote

import com.example.astronautportfolio.data.remote.details.AstronautDetailDto
import com.example.astronautportfolio.data.remote.overview.AstronautsListDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.Response

interface AstronautAPI {
    @GET("astronaut/")
    suspend fun getAstronauts(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int?
    ): AstronautsListDto

    @GET("astronaut/{id}")
    suspend fun getAstronautDetailById(
        @Path("id") id: Int
    ): AstronautDetailDto

    companion object {
        const val BaseURL = "https://ll.thespacedevs.com/2.2.0/"
    }
}

