package com.kottodat.dagger2.scene

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kottodat.dagger2.R
import com.kottodat.dagger2.scene.main.ShopActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startActivity(Intent(this@SplashActivity, ShopActivity::class.java))
    }

}

