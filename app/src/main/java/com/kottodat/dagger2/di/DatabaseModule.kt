package com.kottodat.dagger2.di

import android.app.Application
import androidx.room.Room
import com.kottodat.dagger2.data.db.AppDatabase
import com.kottodat.dagger2.data.db.WeatherRoomDatabase
import com.kottodat.dagger2.data.db.dao.WeatherDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
open class DatabaseModule {

    companion object {
        val instance = DatabaseModule()
    }

    @Singleton
    @Provides
    open fun provideDb(app: Application): AppDatabase =
        Room.databaseBuilder(app, AppDatabase::class.java, "kottosample.db")
            .fallbackToDestructiveMigration()
            .build()

    @Singleton @Provides
    fun provideContributorsDatabase(db: AppDatabase, weatherDao: WeatherDao): WeatherRoomDatabase =
        WeatherRoomDatabase(db, weatherDao)

    @Singleton @Provides
    fun provideWeatherDao(db: AppDatabase): WeatherDao = db.weatherDao()
}