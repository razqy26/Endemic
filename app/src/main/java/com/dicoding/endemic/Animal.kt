package com.dicoding.endemic

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Animal(
    val name : String,
    val latin : String,
    val category: String,
    val photo: Int,
    val description: String
): Parcelable
