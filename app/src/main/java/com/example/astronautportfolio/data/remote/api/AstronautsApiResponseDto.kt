package com.example.astronautportfolio.data.remote.api
import com.example.astronautportfolio.data.remote.dto.overview.AstronautDto
import kotlinx.serialization.Serializable

@Serializable
data class AstronautsApiResponseDto(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<AstronautDto>
)