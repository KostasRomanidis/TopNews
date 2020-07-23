package com.kroman.presentation.di

import com.kroman.presentation.network.createNetworkClient
import com.kroman.presentation.network.newsApi
import org.koin.core.qualifier.named
import org.koin.dsl.module

private const val RETROFIT_INSTANCE = "Retrofit"

val networkModule = module {
    single(named(RETROFIT_INSTANCE)) { createNetworkClient() }
    single { newsApi }
}