package com.udacity.shoestore.screens.instruction

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.utils.SingleLiveEvent

class InstructionViewModel : ViewModel() {

    private val _navigateToList = SingleLiveEvent<Any>()
    val navigateToList: LiveData<Any>
        get() = _navigateToList

    fun onContinue(){
        _navigateToList.call()
    }
}