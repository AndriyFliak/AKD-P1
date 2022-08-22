package com.udacity.shoestore.models

import android.os.Parcelable
import androidx.databinding.BaseObservable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Shoe(
    var name: String, var size: Double, var company: String, var description: String,
    val images: List<String> = mutableListOf()
) : Parcelable, BaseObservable() {

    /* Tried this solution for size 2-way binding as per
    https://developer.android.com/topic/libraries/data-binding/two-way
    and used android:text="@={shoe.size}" in layout but it didn't work. Error:
    Cannot find a getter for <android.widget.EditText android:text> that accepts parameter type 'double'
    @Bindable
    fun getSize(): String {
        return size.toString()
    }
    fun setSize(size: String) {
        this.size = size.toDouble()
    }
*/
}

