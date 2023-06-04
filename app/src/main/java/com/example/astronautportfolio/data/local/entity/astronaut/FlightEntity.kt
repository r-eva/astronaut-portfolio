package com.example.astronautportfolio.data.local.entity.astronaut


import androidx.room.Embedded
import androidx.room.Entity
import kotlinx.serialization.Serializable

@Entity
data class FlightEntity(
    val id: String,
    val image: String,
    val infographic: String?,
    val name: String,
    val url: String
)