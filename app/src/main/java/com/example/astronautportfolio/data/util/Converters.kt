package com.example.astronautportfolio.data.util

import androidx.room.TypeConverter
import com.example.astronautportfolio.data.local.entity.detail.FlightEntity
import com.example.astronautportfolio.data.local.entity.detail.FlightStatusEntity
import com.example.astronautportfolio.data.local.entity.detail.LandingEntity
import com.example.astronautportfolio.data.local.entity.detail.MissionEntity
import com.example.astronautportfolio.data.local.entity.detail.OrbitEntity
import com.example.astronautportfolio.data.local.entity.detail.SpacecraftStatusEntity
import com.example.astronautportfolio.data.local.entity.detail.SpacewalkEntity
import com.example.astronautportfolio.data.local.entity.overview.AgencyEntity
import com.example.astronautportfolio.data.local.entity.overview.AstronautsListEntity
import com.example.astronautportfolio.data.local.entity.overview.ResultEntity
import com.example.astronautportfolio.data.local.entity.overview.StatusEntity
import com.example.astronautportfolio.data.local.entity.overview.TypeEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    // Astronaut List Converter

    @TypeConverter
    fun fromAstronautListEntity(value: AstronautsListEntity): String? {
        return value.let { Gson().toJson(it) }
    }
    @TypeConverter
    fun toAstronautListEntity(value: String): AstronautsListEntity? {
        val listType = object : TypeToken<AstronautsListEntity?>() {}.type
        return value.let { Gson().fromJson(it, listType) }
    }

    @TypeConverter
    fun fromResultEntity(value: List<ResultEntity>?): String? {
        return value.let { Gson().toJson(it) }
    }
    @TypeConverter
    fun toResultEntity(value: String): List<ResultEntity>? {
        val listType = object : TypeToken<List<ResultEntity>?>() {}.type
        return value.let { Gson().fromJson(it, listType) }
    }

    @TypeConverter
    fun fromAgencyEntity(value: AgencyEntity): String? {
        return value.let { Gson().toJson(it) }
    }
    @TypeConverter
    fun toAgencyEntity(value: String): AgencyEntity? {
        val listType = object : TypeToken<AgencyEntity?>() {}.type
        return value.let { Gson().fromJson(it, listType) }
    }

    @TypeConverter
    fun fromTypeEntity(value: TypeEntity): String? {
        return value.let { Gson().toJson(it) }
    }
    @TypeConverter
    fun toTypeEntity(value: String): TypeEntity? {
        val listType = object : TypeToken<TypeEntity?>() {}.type
        return value.let { Gson().fromJson(it, listType) }
    }

    @TypeConverter
    fun fromStatusEntity(value: StatusEntity): String? {
        return value.let { Gson().toJson(it) }
    }
    @TypeConverter
    fun toStatusEntity(value: String): StatusEntity? {
        val listType = object : TypeToken<StatusEntity?>() {}.type
        return value.let { Gson().fromJson(it, listType) }
    }

    // Astronaut Detail Converter

    @TypeConverter
    fun fromFlightEntity(value: List<FlightEntity>?): String? {
        return value?.let { Gson().toJson(it) }
    }
    @TypeConverter
    fun toFlightEntity(value: String?): List<FlightEntity>? {
        val listType = object : TypeToken<FlightEntity?>() {}.type
        return value?.let { Gson().fromJson(it, listType) }
    }

    @TypeConverter
    fun fromLandingEntity(value: List<LandingEntity>?): String? {
        return value?.let { Gson().toJson(it) }
    }
    @TypeConverter
    fun toLandingEntity(value: String?): List<LandingEntity>? {
        val listType = object : TypeToken<LandingEntity?>() {}.type
        return value?.let { Gson().fromJson(it, listType) }
    }

    @TypeConverter
    fun fromSpacewalkEntity(value: List<SpacewalkEntity>?): String? {
        return value?.let { Gson().toJson(it) }
    }
    @TypeConverter
    fun toSpacewalkEntity(value: String?): List<SpacewalkEntity>? {
        val listType = object : TypeToken<SpacewalkEntity?>() {}.type
        return value?.let { Gson().fromJson(it, listType) }
    }

    @TypeConverter
    fun fromFlightStatusEntity(value: FlightStatusEntity): String {
        return value.let { Gson().toJson(it) }
    }
    @TypeConverter
    fun toFlightStatusEntityEntity(value: String): FlightStatusEntity? {
        val listType = object : TypeToken<FlightStatusEntity?>() {}.type
        return value.let { Gson().fromJson(it, listType) }
    }

    @TypeConverter
    fun fromMissionEntity(value: MissionEntity): String {
        return value.let { Gson().toJson(it) }
    }
    @TypeConverter
    fun toMissionEntity(value: String): MissionEntity? {
        val listType = object : TypeToken<MissionEntity?>() {}.type
        return value.let { Gson().fromJson(it, listType) }
    }

    @TypeConverter
    fun fromOrbitEntity(value: OrbitEntity): String {
        return value.let { Gson().toJson(it) }
    }
    @TypeConverter
    fun toOrbitEntity(value: String): OrbitEntity? {
        val listType = object : TypeToken<OrbitEntity?>() {}.type
        return value.let { Gson().fromJson(it, listType) }
    }

    @TypeConverter
    fun fromSpacecraftStatusEntity(value: SpacecraftStatusEntity): String {
        return value.let { Gson().toJson(it) }
    }
    @TypeConverter
    fun toSpacecraftStatusEntity(value: String): SpacecraftStatusEntity? {
        val listType = object : TypeToken<SpacecraftStatusEntity?>() {}.type
        return value.let { Gson().fromJson(it, listType) }
    }

}