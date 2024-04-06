package com.example.myapplication.services

import com.example.myapplication.models.Animal
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface AnimalService {
    @Headers("X-Api-Key: PX0dJON/zPMELVbDeZWmZA==bffgwq0YYJh6AIze")
    @GET("animals")
    fun getAnimals(@Query("name") name: String): Call<List<Animal>>
}



