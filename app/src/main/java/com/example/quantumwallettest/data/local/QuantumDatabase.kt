package com.example.quantumwallettest.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 12/06/23.
 */

@Database(entities = [(User::class)], version = 1, exportSchema = false)
abstract class QuantumDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: QuantumDatabase? = null

        fun getInstance(context: Context): QuantumDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        QuantumDatabase::class.java,
                        "quantum_database"
                    ).fallbackToDestructiveMigration().build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}