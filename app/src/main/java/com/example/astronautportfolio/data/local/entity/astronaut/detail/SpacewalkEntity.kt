package com.example.astronautportfolio.data.local.entity.astronaut.detail


import androidx.room.Entity
import kotlinx.serialization.Serializable

@Entity
data class SpacewalkEntity(
    val duration: String,
    val end: String,
    val id: Int,
    val location: String,
    val name: String,
    val start: String,
    val url: String
)