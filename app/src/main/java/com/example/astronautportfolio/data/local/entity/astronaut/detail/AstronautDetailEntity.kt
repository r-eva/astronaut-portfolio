package com.example.astronautportfolio.data.local.entity.astronaut.detail

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "astronaut_detail")
data class AstronautDetailEntity(
    @PrimaryKey
    val id: Int,
    val flights: List<FlightEntity>? = null,
    val landings: List<LandingEntity>? = null,
    val spacewalks: List<SpacewalkEntity>? = null
)
