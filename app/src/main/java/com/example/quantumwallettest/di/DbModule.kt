package com.example.quantumwallettest.di

import android.content.Context
import androidx.room.Room
import com.example.quantumwallettest.data.local.QuantumDatabase
import com.example.quantumwallettest.data.local.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 12/06/23.
 */

@Module
@InstallIn(SingletonComponent::class)
private object DbModule {
    @Provides
    fun provideUserDao(appDb: QuantumDatabase): UserDao {
        return appDb.userDao()
    }

    @Provides
    @Singleton
    fun provideAppDb(@ApplicationContext context: Context): QuantumDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            QuantumDatabase::class.java,
            "quantumDB"
        ).build()
    }
}