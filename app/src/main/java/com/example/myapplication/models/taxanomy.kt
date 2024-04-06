package com.example.myapplication.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Taxonomy(
    @SerializedName("kingdom") val kingdom: String?,
    @SerializedName("phylum") val phylum: String?,
    @SerializedName("class") val clazz: String?,
    @SerializedName("order") val order: String?,
    @SerializedName("family") val family: String?,
    @SerializedName("genus") val genus: String?,
    @SerializedName("sname") val sname: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(kingdom)
        dest.writeString(phylum)
        dest.writeString(clazz)
        dest.writeString(order)
        dest.writeString(family)
        dest.writeString(genus)
        dest.writeString(sname)
    }


    companion object CREATOR : Parcelable.Creator<Taxonomy> {
        override fun createFromParcel(parcel: Parcel): Taxonomy {
            return Taxonomy(parcel)
        }

        override fun newArray(size: Int): Array<Taxonomy?> {
            return arrayOfNulls(size)
        }
    }
}
