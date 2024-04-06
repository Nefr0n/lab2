package com.example.myapplication.models

import android.os.Parcel
import android.os.Parcelable


data class Animal(
    val name : String,
    val taxonomy: Taxonomy,
    val characteristics: Characteristics
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readParcelable(Taxonomy::class.java.classLoader) ?: Taxonomy("", "", "", "", "", "", ""),
        parcel.readParcelable(Characteristics::class.java.classLoader) ?: Characteristics("", "", "", "", "", "", "", "", "", "", "",)
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeParcelable(taxonomy, flags)
        parcel.writeParcelable(characteristics, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Animal> {
        override fun createFromParcel(parcel: Parcel): Animal {
            return Animal(parcel)
        }

        override fun newArray(size: Int): Array<Animal?> {
            return arrayOfNulls(size)
        }
    }
}
