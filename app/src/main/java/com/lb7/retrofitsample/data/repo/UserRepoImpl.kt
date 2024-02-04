package com.lb7.retrofitsample.data.repo

import com.lb7.retrofitsample.data.mapper.toUser
import com.lb7.retrofitsample.data.network.UserService
import com.lb7.retrofitsample.domain.model.User
import com.lb7.retrofitsample.domain.repo.UserRepo

class UserRepoImpl(
    private val userService: UserService
) : UserRepo {
    override suspend fun getUser(id: String): Result<User> {
        return try {
            Result.success(userService.getUser(id).toUser())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}