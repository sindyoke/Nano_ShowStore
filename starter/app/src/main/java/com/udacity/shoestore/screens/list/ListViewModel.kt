package com.udacity.shoestore.screens.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.utils.SingleLiveEvent

class ListViewModel : ViewModel() {

    private val _list = MutableLiveData<MutableList<Shoe>>(mutableListOf())
    val list: LiveData<MutableList<Shoe>>
        get() = _list

    private val _navigateToDetail = SingleLiveEvent<Any>()
    val navigateToDetail: LiveData<Any>
        get() = _navigateToDetail

    fun onAddDetail() {
        _navigateToDetail.call()
    }

    fun addShoe(shoe: Shoe?) {
        shoe?.let {
            list.value?.add(shoe)
        }
    }
}
