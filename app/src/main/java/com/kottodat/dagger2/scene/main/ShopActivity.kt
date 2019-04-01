package com.kottodat.dagger2.scene.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kottodat.dagger2.di.DaggerCUComponent
import com.kottodat.dagger2.model.Iscream
import javax.inject.Inject

class ShopActivity : AppCompatActivity() {

    @Inject
    lateinit var iscream: Iscream

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sampleComponent = DaggerCUComponent.create()
        sampleComponent.inject(this)

        Toast.makeText(this, iscream.getName(), Toast.LENGTH_SHORT).show()
    }
}