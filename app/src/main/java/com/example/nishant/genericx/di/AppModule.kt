package com.example.nishant.genericx.di

import android.arch.persistence.room.Room
import android.content.Context
import com.example.nishant.genericx.data.database.AppDatabase
import com.example.nishant.genericx.data.database.EventDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by AnEnigmaticBug on 26/6/18.
 */

@Module
class AppModule(private val context: Context) {

    @Provides @Singleton
    fun providesEventDao(appDatabase: AppDatabase): EventDao = appDatabase.eventDao()

    @Provides @Singleton
    fun providesAppDatabase(context: Context): AppDatabase =
            Room.databaseBuilder(context, AppDatabase::class.java, "genericx.db").build()

    @Provides @Singleton
    fun providesContext(): Context = context
}