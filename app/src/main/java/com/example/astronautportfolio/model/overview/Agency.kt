package com.example.astronautportfolio.model.overview


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Agency(
    @SerialName("abbrev")
    val abbrev: String,
    @SerialName("administrator")
    val administrator: String?,
    @SerialName("country_code")
    val countryCode: String?,
    @SerialName("description")
    val description: String?,
    @SerialName("featured")
    val featured: Boolean,
    @SerialName("founding_year")
    val foundingYear: String?,
    @SerialName("id")
    val id: Int,
    @SerialName("image_url")
    val imageUrl: String?,
    @SerialName("launchers")
    val launchers: String,
    @SerialName("logo_url")
    val logoUrl: String?,
    @SerialName("name")
    val name: String,
    @SerialName("parent")
    val parent: String?,
    @SerialName("spacecraft")
    val spacecraft: String,
    @SerialName("type")
    val type: String,
    @SerialName("url")
    val url: String
)