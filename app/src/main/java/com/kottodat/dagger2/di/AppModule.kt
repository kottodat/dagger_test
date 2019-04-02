package com.kottodat.dagger2.di

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import android.content.Context

@Module
internal object AppModule {
    @Singleton
    @Provides
    @JvmStatic
    fun provideContext(application: Application): Context = application
}