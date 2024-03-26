package com.lb7.retrofitsample.data.network

import com.lb7.retrofitsample.data.network.model.UserNetworkModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class UserService(private val client: HttpClient, private val baseUrl: String) {
    suspend fun getUser(id: String): UserNetworkModel {
        return client.get("$baseUrl/posts/$id").body()
    }
}