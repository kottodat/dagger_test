package com.kottodat.dagger2.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kottodat.dagger2.data.db.entity.WeatherEntity

@Dao
abstract class WeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertWeather(weather: WeatherEntity)

    @Query("DELETE FROM weather")
    abstract fun deleteAll()

    //    @Query("SELECT * FROM weather")
//    abstract fun getAllWeather(): Flowable<List<WeatherEntity>>
    @Query("SELECT * FROM weather")
    abstract fun getAllWeather(): List<WeatherEntity>
}