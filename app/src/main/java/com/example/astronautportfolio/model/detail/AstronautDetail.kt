package com.example.astronautportfolio.model.detail

import com.example.astronautportfolio.data.remote.dto.detail.FlightDto
import com.example.astronautportfolio.data.remote.dto.detail.LandingDto
import com.example.astronautportfolio.data.remote.dto.detail.SpacewalkDto

data class AstronautDetail(
    val id: Int,
    val flights: List<Flight>? = null,
    val landings: List<Landing>? = null,
    val spacewalks: List<Spacewalk>? = null
)
