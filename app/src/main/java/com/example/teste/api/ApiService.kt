package com.example.teste.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {
    @Headers("Accept: application/json", "Content-type: application/json")
    @GET("movie/popular")
    fun movies(@Query("api_key") apiKey: String): Call<VideoResponse>
}
