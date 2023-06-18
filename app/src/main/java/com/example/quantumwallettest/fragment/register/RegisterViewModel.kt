package com.example.quantumwallettest.fragment.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.quantumwallettest.data.local.User
import com.example.quantumwallettest.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 11/06/23.
 */

@HiltViewModel
class RegisterViewModel @Inject constructor(private val userRepo: UserRepository) : ViewModel() {
    fun addUser(user: User) {
        userRepo.addUser(user)
    }
}