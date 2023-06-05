package com.example.astronautportfolio.model.overview


import android.os.Parcelable
import com.example.astronautportfolio.model.detail.Flight
import com.example.astronautportfolio.model.detail.Landing
import com.example.astronautportfolio.model.detail.Spacewalk
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
    val wiki: String?
): Parcelable