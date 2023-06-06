package com.example.astronautportfolio.data.remote.dto.detail

import kotlinx.serialization.Serializable

@Serializable
data class AstronautDetailDto(
    val id: Int,
    val flights: List<FlightDto>? = null,
    val landings: List<LandingDto>? = null,
    val spacewalks: List<SpacewalkDto>? = null
)
