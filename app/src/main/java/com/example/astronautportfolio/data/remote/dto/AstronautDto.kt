package com.example.astronautportfolio.data.remote.dto

import androidx.room.Embedded
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AstronautDto(
    @PrimaryKey
    val age: Int,
    @Embedded
    val agency: AgencyDto,
    val bio: String,
    @SerialName("date_of_birth")
    val dateOfBirth: String? = null,
    @SerialName("date_of_death")
    val dateOfDeath: String? = null,
    @SerialName("first_flight")
    val firstFlight: String? = null,
    @SerialName("flights_count")
    val flightsCount: Int,
    val id: Int,
    @SerialName("in_space")
    val inSpace: Boolean,
    val instagram: String? = null,
    @SerialName("landings_count")
    val landingsCount: Int,
    @SerialName("last_flight")
    val lastFlight: String? = null,
    val name: String,
    val nationality: String,
    @SerialName("profile_image")
    val profileImage: String?,
    @SerialName("profile_image_thumbnail")
    val profileImageThumbnail: String? = null,
    @Embedded
    val status: StatusDto,
    val twitter: String?,
    @Embedded
    val type: TypeDto,
    val url: String,
    val wiki: String? = null,
    val flights: List<FlightDto>? = null,
    val landings: List<LandingDto>? = null,
    val spacewalks: List<SpacewalkDto>? = null
)