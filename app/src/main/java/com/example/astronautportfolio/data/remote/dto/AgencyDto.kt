package com.example.astronautportfolio.data.remote.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AgencyDto(
    val abbrev: String? = null,
    val administrator: String? = null,
    @SerialName("country_code")
    val countryCode: String? = null,
    val description: String? = null,
    val featured: Boolean ? = null,
    @SerialName("founding_year")
    val foundingYear: String? = null,
    val id: Int,
    @SerialName("image_url")
    val imageUrl: String? = null,
    val launchers: String? = null,
    @SerialName("logo_url")
    val logoUrl: String? = null,
    val name: String,
    val parent: String? = null,
    val spacecraft: String ?= null,
    val type: String,
    val url: String
)