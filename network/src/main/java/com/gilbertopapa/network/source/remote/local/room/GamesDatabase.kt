package com.gilbertopapa.network.source.remote.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.gilbertopapa.network.source.remote.local.entity.FavoriteGamesEntity
import com.gilbertopapa.network.source.remote.local.entity.GamesEntity
import com.gilbertopapa.network.utils.Converter

@Database(
    entities = [
        GamesEntity::class,
        FavoriteGamesEntity::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converter::class)
abstract class GamesDatabase : RoomDatabase() {
    abstract fun blownDao(): GamesDao
}