package com.example.astronautportfolio.data.local.entity.astronaut

import androidx.room.Entity
import kotlinx.serialization.Serializable

@Entity
data class TypeEntity(
    val id: Int,
    val name: String
)