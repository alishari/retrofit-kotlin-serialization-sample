package com.lb7.retrofitsample.data.network

import com.lb7.retrofitsample.data.network.model.UserNetworkModel
import retrofit2.http.GET
import retrofit2.http.Path

interface UserService {
    @GET("posts/{id}")
    suspend fun getUser(@Path("id") id: String?): UserNetworkModel
}