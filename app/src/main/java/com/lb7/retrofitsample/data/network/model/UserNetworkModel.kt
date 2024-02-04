package com.lb7.retrofitsample.data.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserNetworkModel(
    @SerialName("userId") val userId: Int? = null,
    @SerialName("id") val id: Int? = null,
    @SerialName("title") val title: String? = null,
    @SerialName("body") val body: String? = null
)