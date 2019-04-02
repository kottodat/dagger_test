package com.kottodat.dagger2.scene.main

import android.os.Bundle
import android.widget.Toast
import com.kottodat.dagger2.model.Iscream
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class ShopActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var iscream: Iscream

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Toast.makeText(this, iscream.getName(), Toast.LENGTH_SHORT).show()

    }

}