package com.example.quantumwallettest.fragment.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quantumwallettest.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 12/06/23.
 */

@HiltViewModel
class LoginViewModel @Inject constructor(private val userRepo: UserRepository) : ViewModel() {

    private val _shouldVerified = MutableSharedFlow<Boolean>()
    val shouldVerified = _shouldVerified.asSharedFlow()

    fun getUserByPhone(phone: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val user = userRepo.getUserByPhone(phone)
            user?.let {
                _shouldVerified.emit(true)
            } ?: _shouldVerified.emit(false)
        }
    }
}