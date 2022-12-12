package com.example.projectkotlin.RetrofitApiData


import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("services")
    fun getServices() : Call<ServicesSetterGetter>

}