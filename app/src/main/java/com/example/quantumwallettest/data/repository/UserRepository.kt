package com.example.quantumwallettest.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.quantumwallettest.data.local.User
import com.example.quantumwallettest.data.local.UserDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 12/06/23.
 */

class UserRepository(private val userDao: UserDao) {
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    fun addUser(user: User) {
        coroutineScope.launch(Dispatchers.IO) {
            userDao.addUser(user)
        }
    }

    suspend fun getUserByPhone(phone: String): User? {
        return userDao.findUserByPhone(phone)
    }
}