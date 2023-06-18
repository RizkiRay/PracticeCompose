package com.example.quantumwallettest.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 12/06/23.
 */

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUser(user: User)

    @Query("SELECT * FROM users WHERE phone = :phone")
    suspend fun findUserByPhone(phone: String): User?
}