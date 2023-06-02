package com.example.astronautportfolio.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.astronautportfolio.data.local.dao.AstronautDao
import com.example.astronautportfolio.data.local.dao.PagingRemoteKeysDao
import com.example.astronautportfolio.data.local.dao.SelectedAstronautDao
import com.example.astronautportfolio.data.local.entity.detail.AstronautDetailEntity
import com.example.astronautportfolio.data.local.entity.overview.AstronautsListEntity
import com.example.astronautportfolio.data.local.entity.overview.ResultEntity
import com.example.astronautportfolio.data.local.entity.paging.PagingRemoteKeysEntity
import com.example.astronautportfolio.data.remote.details.AstronautDetailDto
import com.example.astronautportfolio.data.util.Converters

@Database(
    entities = [
        ResultEntity::class,
        AstronautsListEntity::class,
        PagingRemoteKeysEntity::class,
        AstronautDetailEntity::class
               ],
    version = 1
)
@TypeConverters(Converters::class)
abstract class AstronautDatabase: RoomDatabase() {
    abstract fun astronautDao(): AstronautDao
    abstract fun pagingRemoteKeysDao(): PagingRemoteKeysDao
    abstract fun selectedAstronautDao(): SelectedAstronautDao

    companion object {
        private var dbINSTANCE: AstronautDatabase ? = null
        fun getAppDB(context: Context): AstronautDatabase {
            if(dbINSTANCE == null) {
                dbINSTANCE = Room.databaseBuilder<AstronautDatabase>(
                    context.applicationContext, AstronautDatabase::class.java, "astronauts.db"
                ).allowMainThreadQueries().build()
            }
            return dbINSTANCE!!
        }
    }
}