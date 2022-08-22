package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoesViewModel : ViewModel() {
    private val _shoeList = MutableLiveData<MutableList<Shoe>>(mutableListOf())
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    private val _eventSave = MutableLiveData(false)
    val eventSave: LiveData<Boolean>
        get() = _eventSave

    fun onEventSave(shoe: Shoe) {
        _eventSave.value = true
        _shoeList.value?.add(shoe)
    }

    fun onEventSaveComplete() {
        _eventSave.value = false
    }

    private val _eventCancel = MutableLiveData(false)
    val eventCancel: LiveData<Boolean>
        get() = _eventCancel

    fun onEventCancel() {
        _eventCancel.value = true
    }

    fun onEventCancelComplete() {
        _eventCancel.value = false
    }
}