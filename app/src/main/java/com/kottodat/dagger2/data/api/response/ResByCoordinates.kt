package com.kottodat.dagger2.data.api.response

data class ResByCoordinates(
    val clouds: Clouds,
    val cod: Int,
    val coord: Coord,
    val dt: Int,
    val id: Int,
    val main: Main,
    val name: String,
//    val rain: Rain,
    val sys: Sys,
    val weather: List<Weather>,
    val wind: Wind
)

data class Coord(
    val lat: Double,
    val lon: Double
)

data class Main(
    val humidity: Int,
    val pressure: Double,
    val temp: Double,
    val temp_max: Double,
    val temp_min: Double
)

data class Weather(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)

//data class Rain(
//    val 3h: Int
//)

data class Wind(
    val deg: Double,
    val speed: Double
)

data class Clouds(
    val all: Int
)

data class Sys(
    val country: String,
    val sunrise: Int,
    val sunset: Int
)