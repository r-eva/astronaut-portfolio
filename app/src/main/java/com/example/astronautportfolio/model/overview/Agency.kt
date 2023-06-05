package com.example.astronautportfolio.model.overview

data class Agency(
    val abbrev: String?,
    val administrator: String?,
    val countryCode: String?,
    val description: String?,
    val featured: Boolean?,
    val foundingYear: String?,
    val id: Int,
    val imageUrl: String?,
    val launchers: String?,
    val logoUrl: String?,
    val name: String,
    val parent: String?,
    val spacecraft: String?,
    val type: String,
    val url: String
)