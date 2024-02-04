package com.lb7.retrofitsample.di

import com.lb7.retrofitsample.data.network.UserService
import com.lb7.retrofitsample.data.repo.UserRepoImpl
import com.lb7.retrofitsample.domain.repo.UserRepo
import com.lb7.retrofitsample.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    single<UserService> {
        get<Retrofit>().create(UserService::class.java)
    }
    singleOf(::UserRepoImpl) { bind<UserRepo>() }
    viewModelOf(::MainViewModel)
}