package com.example.astronautportfolio.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.astronautportfolio.data.local.entity.astronaut.overview.AstronautEntity
import com.example.astronautportfolio.data.local.entity.astronaut.detail.FlightEntity
import com.example.astronautportfolio.data.local.entity.astronaut.detail.LandingEntity
import com.example.astronautportfolio.data.local.entity.astronaut.detail.SpacewalkEntity

@Dao
interface AstronautDao {

    /// Astronaut List DAO
    @Query("SELECT * FROM astronaut")
    fun pagingSource(): PagingSource<Int, AstronautEntity>

    @Upsert
    suspend fun upsertAll(astronautsList: List<AstronautEntity>)

    @Query("DELETE FROM astronaut")
    suspend fun clearAll()


}