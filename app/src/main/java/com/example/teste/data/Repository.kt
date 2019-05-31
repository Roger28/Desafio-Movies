package com.example.teste.data

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.example.teste.api.ApiService
import com.example.teste.api.ServiceGenerator
import com.example.teste.api.VideoResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    fun movies(): LiveData<VideoResponse> {
        val data = MutableLiveData<VideoResponse>()
        val apiService = ServiceGenerator.createService(ApiService::class.java)
//        val call = apiService.movies(BuildConfig.ApiToken)
        val call = apiService.movies("61e66f4478be035d176b1382fe38d6ce")
        call.enqueue(object : Callback<VideoResponse> {
            override fun onResponse(call: Call<VideoResponse>, response: Response<VideoResponse>) {
                if (response.isSuccessful)
                    data.value = response.body()
            }

            override fun onFailure(call: Call<VideoResponse>, t: Throwable) {

            }
        })
        return data
    }
}
