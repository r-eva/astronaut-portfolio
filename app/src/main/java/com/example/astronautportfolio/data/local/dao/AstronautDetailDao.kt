package com.example.astronautportfolio.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.astronautportfolio.data.local.entity.astronaut.detail.AstronautDetailEntity

@Dao
interface AstronautDetailDao {

    @Query("SELECT * FROM astronaut_detail WHERE id =:id")
    suspend fun getAstronautDetailById(id: Int): AstronautDetailEntity

    @Upsert
    suspend fun addAstronautDetail(astronautsDetail: AstronautDetailEntity)

    @Query("DELETE FROM astronaut WHERE id = :astronautId")
    suspend fun deleteAstronaut(astronautId: Int)
}