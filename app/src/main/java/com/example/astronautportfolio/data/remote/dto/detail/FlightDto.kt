package com.example.astronautportfolio.data.remote.dto.detail

import androidx.room.Embedded
import kotlinx.serialization.Serializable
@Serializable
data class FlightDto(
    val id: String,
    val image: String,
    val infographic: String? = null,
    val name: String,
    val url: String
)