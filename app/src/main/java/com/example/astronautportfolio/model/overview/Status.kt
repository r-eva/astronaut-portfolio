package com.example.astronautportfolio.model.overview


import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Status(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String
)