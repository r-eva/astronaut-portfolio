package com.example.astronautportfolio.data.local.entity.astronaut


import androidx.room.Embedded
import androidx.room.Entity
import kotlinx.serialization.Serializable

@Entity
data class LandingEntity(
    val destination: String,
    val id: Int,
    val url: String
)