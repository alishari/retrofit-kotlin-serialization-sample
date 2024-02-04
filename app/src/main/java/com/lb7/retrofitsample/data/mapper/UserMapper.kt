package com.lb7.retrofitsample.data.mapper

import com.lb7.retrofitsample.data.network.model.UserNetworkModel
import com.lb7.retrofitsample.domain.model.User

fun UserNetworkModel.toUser(): User {
    return User(
        userId = userId.orEmpty(),
        id = id.orEmpty(),
        title = title.orEmpty(),
        body = body.orEmpty()
    )
}