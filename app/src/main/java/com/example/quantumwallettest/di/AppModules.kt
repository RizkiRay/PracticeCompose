package com.example.quantumwallettest.di

import com.example.quantumwallettest.data.local.UserDao
import com.example.quantumwallettest.data.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 12/06/23.
 */

@Module
@InstallIn(SingletonComponent::class)
class AppModules {
    @Singleton
    @Provides
    fun provideUserRepo(userDao: UserDao): UserRepository {
        return UserRepository(userDao)
    }
}