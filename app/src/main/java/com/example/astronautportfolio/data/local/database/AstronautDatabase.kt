package com.example.astronautportfolio.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.astronautportfolio.data.local.dao.AstronautDao
import com.example.astronautportfolio.data.local.dao.PagingRemoteKeysDao
import com.example.astronautportfolio.data.local.entity.overview.AstronautsListEntity
import com.example.astronautportfolio.data.local.entity.overview.ResultEntity
import com.example.astronautportfolio.data.local.entity.paging.PagingRemoteKeysEntity
import com.example.astronautportfolio.data.util.Converters

@Database(
    entities = [
        ResultEntity::class,
        AstronautsListEntity::class,
        PagingRemoteKeysEntity::class,
               ],
    version = 1
)
@TypeConverters(Converters::class)
abstract class AstronautDatabase: RoomDatabase() {
    abstract fun astronautDao(): AstronautDao
    abstract fun pagingRemoteKeysDao(): PagingRemoteKeysDao
}