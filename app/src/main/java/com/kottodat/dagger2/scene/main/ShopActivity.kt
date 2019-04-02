package com.kottodat.dagger2.scene.main

import android.os.Bundle
import android.widget.Toast
import com.kottodat.dagger2.data.WeatherRepository
import com.kottodat.dagger2.data.api.response.ResByCoordinates
import com.kottodat.dagger2.model.Iscream
import dagger.android.support.DaggerAppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class ShopActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var iscream: Iscream

    @Inject
    lateinit var weatherRepository: WeatherRepository


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Toast.makeText(this, iscream.getName(), Toast.LENGTH_SHORT).show()

        weatherRepository.getSampleData {
            if( it ) {
                weatherRepository.getLocalData {
                    Toast.makeText(this, "성공", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "실패", Toast.LENGTH_SHORT).show()
            }
        }


    }

}