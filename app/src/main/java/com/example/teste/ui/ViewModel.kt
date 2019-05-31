package com.example.teste.ui

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData

import com.example.teste.api.VideoResponse
import com.example.teste.data.Repository

class ViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: Repository = Repository()
    private val data: LiveData<VideoResponse>? = null
    private val movies: LiveData<VideoResponse>

    init {
        this.movies = this.repository.movies()
    }

    fun movies(): LiveData<VideoResponse> {
        return this.movies
    }

}
