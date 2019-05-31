package com.example.teste.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import java.io.Serializable

class Video(@field:SerializedName("title")
            @field:Expose
            var title: String?, poster_path: String, @field:SerializedName("overview")
            @field:Expose
            var overview: String?) : Serializable {

    @SerializedName("poster_path")
    @Expose
    var poster_path: String? = null
        get() = URL + "" + field

    init {
        this.poster_path = poster_path
    }

    companion object {

        private const val URL = "https://image.tmdb.org/t/p/w500"
    }
}
