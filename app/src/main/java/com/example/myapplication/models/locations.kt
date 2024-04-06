package com.example.myapplication.models

import com.google.gson.annotations.SerializedName

data class Locations(
    @SerializedName("locations") val locations: List<String>
)
