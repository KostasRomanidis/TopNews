package com.kroman.presentation.di

import com.kroman.domain.usecases.ArticlesUseCases
import org.koin.dsl.module

val useCasesModule = module {
    factory { ArticlesUseCases(articleRepository = get()) }
}