package com.kottodat.dagger2.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kottodat.dagger2.data.db.dao.WeatherDao
import com.kottodat.dagger2.data.db.entity.WeatherEntity

@Database(
    entities = [
        (WeatherEntity::class)
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun weatherDao(): WeatherDao
}