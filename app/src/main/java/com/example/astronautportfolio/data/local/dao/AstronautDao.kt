package com.example.astronautportfolio.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.astronautportfolio.data.local.entity.astronaut.AstronautEntity
import com.example.astronautportfolio.data.local.entity.astronaut.FlightEntity
import com.example.astronautportfolio.data.local.entity.astronaut.LandingEntity
import com.example.astronautportfolio.data.local.entity.astronaut.SpacewalkEntity

@Dao
interface AstronautDao {

    /// Astronaut List DAO
    @Query("SELECT * FROM astronaut")
    fun pagingSource(): PagingSource<Int, AstronautEntity>

    @Query("SELECT * FROM astronaut")
    fun getAllAstronautFromDb(): List<AstronautEntity>

    @Upsert
    suspend fun upsertAll(astronautsList: List<AstronautEntity>)

    @Query("DELETE FROM astronaut")
    suspend fun clearAll()

    @Query("SELECT * FROM astronaut WHERE id =:id")
    suspend fun getAstronautDetailById(id: Int): AstronautEntity

    @Query("UPDATE astronaut SET flights=:astronautFlight, landings=:astronautLanding, spacewalks=:astronautSpacewalk WHERE id=:astronautId")
    suspend fun addAstronautDetail(
        astronautId: Int,
        astronautFlight:
        List<FlightEntity>?,
        astronautLanding: List<LandingEntity>?,
        astronautSpacewalk: List<SpacewalkEntity>?
    )

    @Query("DELETE FROM astronaut WHERE id = :astronautId")
    suspend fun deleteAstronaut(astronautId: Int)


}