package com.kottodat.dagger2.data.db

import com.kottodat.dagger2.data.db.entity.WeatherEntity

interface WeatherDatabase {

    fun insertWeather(weather:WeatherEntity)
    fun deleteAll()
    fun getAllWeather(): List<WeatherEntity>
//    fun getAllWeather(): Flowable<List<WeatherEntity>>
}
