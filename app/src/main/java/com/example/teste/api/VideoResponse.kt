package com.example.teste.api

import com.example.teste.model.Video
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class VideoResponse(@field:SerializedName("results")
                    @field:Expose
                    var videos: List<Video>?)
