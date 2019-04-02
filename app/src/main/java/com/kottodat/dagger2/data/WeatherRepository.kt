package com.kottodat.dagger2.data

import android.os.AsyncTask
import com.kottodat.dagger2.data.api.OpenWeatherMapApi
import com.kottodat.dagger2.data.api.response.ResByCoordinates
import com.kottodat.dagger2.data.db.WeatherRoomDatabase
import com.kottodat.dagger2.data.db.entity.WeatherEntity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.Callable
import java.util.concurrent.Executors
import javax.inject.Inject


class WeatherRepository @Inject constructor(
    private val openWeatherMapApi: OpenWeatherMapApi,
    private val weatherRoomDatabase: WeatherRoomDatabase
) {

    fun getSampleData(onResult: (Boolean) -> Unit) {


        val call = openWeatherMapApi.byCoordinates("37.277488", "127.0145353")
        call.enqueue(object : Callback<ResByCoordinates> {
            override fun onResponse(call: Call<ResByCoordinates>, response: Response<ResByCoordinates>) {
                response.body()?.let {


                    AgentAsyncTask(it, weatherRoomDatabase, onResult).execute()

                }

            }

            override fun onFailure(call: Call<ResByCoordinates>, t: Throwable) {
                t.printStackTrace()
                onResult(false)
            }
        })
    }

    fun getLocalData(onResult: (List<WeatherEntity>) -> Unit) {
        onResult(getLocalData())

    }

    fun getLocalData(): List<WeatherEntity> {
        val callable: Callable<List<WeatherEntity>> = Callable<List<WeatherEntity>> {
            weatherRoomDatabase.getAllWeather()
        }
        val future = Executors.newSingleThreadExecutor().submit(callable)
        return future.get()
    }

    private class AgentAsyncTask(
        private val resByCoordinates: ResByCoordinates,
        private val weatherRoomDatabase: WeatherRoomDatabase,
        private val onResult: (Boolean) -> Unit
    ) : AsyncTask<Void, Void, Int>() {

        override fun doInBackground(vararg params: Void): Int? {
            weatherRoomDatabase.insertWeather(
                WeatherEntity(
                    humidity = resByCoordinates.main.humidity,
                    pressure = resByCoordinates.main.pressure,
                    temp = resByCoordinates.main.temp,
                    time = System.currentTimeMillis()
                )
            )
            return 0
        }

        override fun onPostExecute(agentsCount: Int?) {
            onResult(true)
        }
    }

//            .doOnSuccess {
//                var main = it.main
//                var entity =
//                    WeatherEntity(main.humidity, main.pressure, main.humidity, main.temp, System.currentTimeMillis())
//                weatherRoomDatabase.insertWeather(entity)
//            }
//            .subscribeOn(Schedulers.computation())
//            .observeOn(AndroidSchedulers.mainThread()).toCompletable()

//    fun getSampleData(): Completable =
//        openWeatherMapApi.byCoordinates("37.277488", "127.0145353")
//            .doOnSuccess {
//                var main = it.main
//                var entity =
//                    WeatherEntity(main.humidity, main.pressure, main.humidity, main.temp, System.currentTimeMillis())
//                weatherRoomDatabase.insertWeather(entity)
//            }
//            .subscribeOn(Schedulers.computation())
//            .observeOn(AndroidSchedulers.mainThread()).toCompletable()

}