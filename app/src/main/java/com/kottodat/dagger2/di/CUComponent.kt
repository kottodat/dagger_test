package com.kottodat.dagger2.di

import com.kottodat.dagger2.scene.main.ShopActivity
import dagger.Component

@Component(modules = [HaagendazsModule::class])
interface CUComponent {
    fun inject(activity: ShopActivity)

}