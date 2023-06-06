package com.example.astronautportfolio.data.local.entity.astronaut.overview


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.astronautportfolio.data.local.entity.astronaut.detail.FlightEntity
import com.example.astronautportfolio.data.local.entity.astronaut.detail.LandingEntity
import com.example.astronautportfolio.data.local.entity.astronaut.detail.SpacewalkEntity

@Entity (tableName = "astronaut")
data class AstronautEntity(
    val age: Int,
    val agency: AgencyEntity,
    val bio: String,
    val dateOfBirth: String?,
    val dateOfDeath: String?,
    val firstFlight: String?,
    val flightsCount: Int,
    @PrimaryKey
    val id: Int,
    val inSpace: Boolean,
    val instagram: String?,
    val landingsCount: Int,
    val lastFlight: String?,
    val name: String,
    val nationality: String,
    val profileImage: String?,
    val profileImageThumbnail: String?,
    val status: StatusEntity,
    val twitter: String?,
    val type: TypeEntity,
    val url: String,
    val wiki: String?
)