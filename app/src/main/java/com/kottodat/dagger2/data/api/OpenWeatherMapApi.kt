package com.kottodat.dagger2.data.api

import androidx.annotation.CheckResult
import com.kottodat.dagger2.data.api.response.ResByCoordinates
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherMapApi {
    @GET("weather")
    @CheckResult
    fun byCoordinates(@Query("lat") lat: String, @Query("lon") lon: String):
            Call<ResByCoordinates>
//    fun byCoordinates(@Query("lat") lat: String, @Query("lon") lon: String):
//            Single<ResByCoordinates>
}
