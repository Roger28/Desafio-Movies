package com.example.teste.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceGenerator {
    private const val URL = "https://api.themoviedb.org/3/"

    private var builder: Retrofit.Builder = Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())

    private var retrofit = builder.build()

    private val loggingInteceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    private val httpClientBuilder = OkHttpClient.Builder()

    fun <S> createService(serviceClass: Class<S>): S {
        if (!httpClientBuilder.interceptors().contains(loggingInteceptor)) {
            httpClientBuilder.addInterceptor(loggingInteceptor)
            builder = builder.client(httpClientBuilder.build())
            retrofit = builder.build()
        }
        return retrofit.create(serviceClass)
    }
}
