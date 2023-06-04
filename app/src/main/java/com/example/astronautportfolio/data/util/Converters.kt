package com.example.astronautportfolio.data.util

import androidx.room.TypeConverter
import com.example.astronautportfolio.data.local.entity.astronaut.FlightEntity
import com.example.astronautportfolio.data.local.entity.astronaut.LandingEntity
import com.example.astronautportfolio.data.local.entity.astronaut.SpacewalkEntity
import com.example.astronautportfolio.data.local.entity.astronaut.AgencyEntity
import com.example.astronautportfolio.data.local.entity.astronaut.StatusEntity
import com.example.astronautportfolio.data.local.entity.astronaut.TypeEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    // Astronaut List Converter
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
        /// abis selesai call api langsung kesini
        println("from flight entity $value")
        return value?.let { Gson().toJson(it) }
    }
    @TypeConverter
    fun toFlightEntity(value: String?): List<FlightEntity>? {
        println("to flight entity $value")
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



    /*@TypeConverter
    fun fromListFlight(value: List<FlightEntity>?): String = Gson().toJson(value)

    @TypeConverter
    fun toListFlight(value: String) = Gson().fromJson(value, Array<FlightEntity>::class.java).toList()

    @TypeConverter
    fun fromListLanding(value: List<LandingEntity>?): String = Gson().toJson(value)

    @TypeConverter
    fun toListLanding(value: String) = Gson().fromJson(value, Array<LandingEntity>::class.java).toList()

    @TypeConverter
    fun fromListSpacewalk(value: List<SpacewalkEntity>?): String = Gson().toJson(value)

    @TypeConverter
    fun toListSpacewalk(value: String) = Gson().fromJson(value, Array<SpacewalkEntity>::class.java).toList()

     */




}