package com.kottodat.dagger2.di

import com.kottodat.dagger2.di.activitymodule.ShopActivityModule
import com.kottodat.dagger2.scene.main.ShopActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityBindingMoudle
{
    @ContributesAndroidInjector(modules = [ShopActivityModule::class])
    fun shopActivity(): ShopActivity
}