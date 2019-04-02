package com.kottodat.dagger2.data.db

import androidx.annotation.CheckResult
import androidx.room.RoomDatabase
import com.kottodat.dagger2.data.db.dao.WeatherDao
import com.kottodat.dagger2.data.db.entity.WeatherEntity
import javax.inject.Inject


class WeatherRoomDatabase @Inject constructor(
    private val database: RoomDatabase,
    private val weatherDao: WeatherDao
) : WeatherDatabase {
    override fun insertWeather(weather: WeatherEntity) {
        database.runInTransaction {
            weatherDao.insertWeather(weather)
        }
    }

    override fun deleteAll() {
        weatherDao.deleteAll()
    }

//    @CheckResult
//    override fun getAllWeather(): Flowable<List<WeatherEntity>> =
//        weatherDao.getAllWeather()
    @CheckResult
    override fun getAllWeather(): List<WeatherEntity> =
        weatherDao.getAllWeather()

}