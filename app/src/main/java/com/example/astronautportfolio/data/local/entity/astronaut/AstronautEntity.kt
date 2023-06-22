package com.example.astronautportfolio.data.local.entity.astronaut


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.astronautportfolio.data.remote.dto.FlightDto
import com.example.astronautportfolio.data.remote.dto.LandingDto
import com.example.astronautportfolio.data.remote.dto.SpacewalkDto

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
    val wiki: String?,
    val flights: List<FlightEntity>? = null,
    val landings: List<LandingEntity>? = null,
    val spacewalks: List<SpacewalkEntity>? = null
)