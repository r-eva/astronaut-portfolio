package com.example.astronautportfolio.data.local.entity.astronaut.overview


import androidx.room.Entity
import kotlinx.serialization.Serializable

@Entity
data class StatusEntity(
    val id: Int,
    val name: String
)