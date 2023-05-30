package com.example.astronautportfolio.model.detail


import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class Spacewalk(
    @SerializedName("duration")
    val duration: String,
    @SerializedName("end")
    val end: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("location")
    val location: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("start")
    val start: String,
    @SerializedName("url")
    val url: String
)