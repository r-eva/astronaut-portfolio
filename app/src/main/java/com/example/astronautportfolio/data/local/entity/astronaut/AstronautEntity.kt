package com.example.astronautportfolio.data.local.entity.astronaut


import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

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
    val flights: List<FlightEntity>?,
    val landings: List<LandingEntity>?,
    val spacewalks: List<SpacewalkEntity>?
)