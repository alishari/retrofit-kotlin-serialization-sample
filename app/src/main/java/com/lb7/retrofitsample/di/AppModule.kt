package com.lb7.retrofitsample.di

import com.lb7.retrofitsample.data.network.UserService
import com.lb7.retrofitsample.data.repo.UserRepoImpl
import com.lb7.retrofitsample.domain.repo.UserRepo
import com.lb7.retrofitsample.ui.main.MainViewModel
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.android.BuildConfig
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

private const val BASE_URL = "https://jsonplaceholder.typicode.com"

val appModule = module {

    single<Json> {
        Json {
            ignoreUnknownKeys = true
            isLenient = true
            prettyPrint = true
        }
    }

    single<HttpClient> {
        HttpClient(CIO) {
            if (BuildConfig.DEBUG) {
                install(Logging)
            }
            install(ContentNegotiation) {
                json(get<Json>())
            }
        }
    }

    single {
        UserService(get(), BASE_URL)
    }
    singleOf(::UserRepoImpl) { bind<UserRepo>() }
    viewModelOf(::MainViewModel)
}