package com.example.myapplication.models

import android.os.Parcel
import android.os.Parcelable

data class Characteristics(
    val aosmaturity: String,
    val aoweaning: String,
    val alsize: String,
    val bthreat: String,
    val color: String,
    val cname: String,
    val diet: String,
    val epsize: String,
    val qperiod: String,
    val group: String,
    val gbehavior: String,
) : Parcelable {
    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        TODO("Not yet implemented")
    }
}