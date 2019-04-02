package com.kottodat.dagger2.di.activitymodule

import androidx.appcompat.app.AppCompatActivity
import com.kottodat.dagger2.di.HaagendazsModule
import com.kottodat.dagger2.scene.main.ShopActivity
import dagger.Binds
import dagger.Module

@Module(includes = [HaagendazsModule::class])
abstract class  ShopActivityModule {

    @Binds
    abstract fun providesAppCompatActivity(shopActivity: ShopActivity): AppCompatActivity

//    @Module
//    companion object {
//        @Provides
//        @JvmStatic
//        fun provideIscream(): Iscream {
//            return VanillaIscream()
//        }
//    }
}