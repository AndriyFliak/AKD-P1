package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {
    private val _shoeList = MutableLiveData<MutableList<Shoe>>(mutableListOf())
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    fun addShoe(name: String, size: String, company: String, description: String) {
        val shoe = Shoe(name, size.toDoubleOrNull() ?: 0.0, company, description)
        _shoeList.value?.add(shoe)
        _shoeList.postValue(_shoeList.value)
    }


}