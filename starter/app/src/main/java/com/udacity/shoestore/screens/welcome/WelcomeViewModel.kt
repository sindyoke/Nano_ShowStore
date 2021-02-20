package com.udacity.shoestore.screens.welcome

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.utils.SingleLiveEvent

class WelcomeViewModel : ViewModel() {

    private val _navigateToIntroduction = SingleLiveEvent<Any>()
    val navigateToIntroduction: LiveData<Any>
        get() = _navigateToIntroduction

    fun onContinue(){
        _navigateToIntroduction.call()
    }
}