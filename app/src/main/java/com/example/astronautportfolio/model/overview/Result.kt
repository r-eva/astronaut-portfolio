package com.example.astronautportfolio.model.overview


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Result(
    @SerialName("age")
    val age: Int,
    @SerialName("agency")
    val agency: Agency,
    @SerialName("bio")
    val bio: String,
    @SerialName("date_of_birth")
    val dateOfBirth: String?,
    @SerialName("date_of_death")
    val dateOfDeath: String?,
    @SerialName("first_flight")
    val firstFlight: String?,
    @SerialName("flights_count")
    val flightsCount: Int,
    @SerialName("id")
    val id: Int,
    @SerialName("in_space")
    val inSpace: Boolean,
    @SerialName("instagram")
    val instagram: String?,
    @SerialName("landings_count")
    val landingsCount: Int,
    @SerialName("last_flight")
    val lastFlight: String?,
    @SerialName("name")
    val name: String,
    @SerialName("nationality")
    val nationality: String,
    @SerialName("profile_image")
    val profileImage: String?,
    @SerialName("profile_image_thumbnail")
    val profileImageThumbnail: String?,
    @SerialName("status")
    val status: Status,
    @SerialName("twitter")
    val twitter: String?,
    @SerialName("type")
    val type: Type,
    @SerialName("url")
    val url: String,
    @SerialName("wiki")
    val wiki: String?
)