package com.example.astronautportfolio.data.remote.overview

import com.example.astronautportfolio.data.remote.overview.dto.AstronautsListDto
import retrofit2.http.GET
import retrofit2.http.Query

interface AstronautAPI {
    @GET("astronaut/")
    suspend fun getAstronauts(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): AstronautsListDto

    companion object {
        const val BaseURL = "https://ll.thespacedevs.com/2.2.0/"
    }
}

