package com.example.astronautportfolio.model


import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class Astronaut(
    val age: Int,
    val agency: @RawValue Agency,
    val bio: String,
    val dateOfBirth: String?,
    val dateOfDeath: String?,
    val firstFlight: String?,
    val flightsCount: Int,
    val id: Int,
    val inSpace: Boolean,
    val instagram: String?,
    val landingsCount: Int,
    val lastFlight: String?,
    val name: String,
    val nationality: String,
    val profileImage: String?,
    val profileImageThumbnail: String?,
    val status: @RawValue Status,
    val twitter: String?,
    val type: @RawValue Type,
    val url: String,
    val wiki: String?,
    val flights: @RawValue List<Flight>? = null,
    val landings: @RawValue List<Landing>? = null,
    val spacewalks: @RawValue List<Spacewalk>? = null
): Parcelable