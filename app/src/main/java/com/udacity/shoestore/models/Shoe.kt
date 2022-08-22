package com.udacity.shoestore.models

import android.os.Parcelable
import androidx.databinding.InverseMethod
import kotlinx.parcelize.Parcelize

@Parcelize
data class Shoe(
    var name: String, var size: Double, var company: String, var description: String,
    val images: List<String> = mutableListOf()
) : Parcelable {

    object Converter {
        @InverseMethod("stringToDouble")
        @JvmStatic
        fun doubleToString(value: Double): String {
            return if (value != 0.0) value.toString() else ""
        }

        @JvmStatic
        fun stringToDouble(value: String): Double {
            return if (value.isNotEmpty()) value.toDouble() else 0.0
        }
    }
}

