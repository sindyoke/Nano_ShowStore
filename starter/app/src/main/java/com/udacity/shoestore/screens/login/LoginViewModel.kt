package com.udacity.shoestore.screens.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.utils.SingleLiveEvent

class LoginViewModel : ViewModel() {

    private val _navigateToWelcome = SingleLiveEvent<Any>()
    val navigateToWelcome: LiveData<Any>
        get() = _navigateToWelcome

    fun onCreateUser() {
        _navigateToWelcome.call()
    }

    fun onLoginUser() {
        _navigateToWelcome.call()
    }
}