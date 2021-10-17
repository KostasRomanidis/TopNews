package com.kroman.presentation.di

import com.kroman.domain.usecases.TopHeadlinesUseCases
import org.koin.dsl.module

val useCasesModule = module {
    factory { TopHeadlinesUseCases(articleRepository = get()) }
}