package com.lb7.retrofitsample.domain.repo

import com.lb7.retrofitsample.domain.model.User

interface UserRepo {
    suspend fun getUser(id: String): Result<User>
}