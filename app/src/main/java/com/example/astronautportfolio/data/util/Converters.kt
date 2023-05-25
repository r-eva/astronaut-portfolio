package com.example.astronautportfolio.data.util

import androidx.room.TypeConverter
import com.example.astronautportfolio.data.local.entity.AgencyEntity
import com.example.astronautportfolio.data.local.entity.ResultEntity
import com.example.astronautportfolio.data.local.entity.StatusEntity
import com.example.astronautportfolio.data.local.entity.TypeEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

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
}