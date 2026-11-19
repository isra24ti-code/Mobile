package com.example.p3isra.Home.data.api

import com.example.p3isra.Home.data.model.PhotoModel
import retrofit2.http.GET

interface PhotoApiService {
    @GET("list")
    suspend fun getPhotos(): List<PhotoModel>
}