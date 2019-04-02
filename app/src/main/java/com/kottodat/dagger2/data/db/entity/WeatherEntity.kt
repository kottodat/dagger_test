package com.kottodat.dagger2.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather")
data class WeatherEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @ColumnInfo(name = "humidity")
    var humidity: Int,
    @ColumnInfo(name = "pressure")
    var pressure: Double,
    @ColumnInfo(name = "temp")
    var temp: Double,
    @ColumnInfo(name = "tiem")
    var time: Long

)