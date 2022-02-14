package com.example.animlist_clean_mvvm_koin.di

import com.example.animlist_clean_mvvm_koin.data.AnimeDataSource
import com.example.animlist_clean_mvvm_koin.domain.repository.AnimeRepository
import com.example.animlist_clean_mvvm_koin.domain.useCase.AnimeUseCase
import com.example.animlist_clean_mvvm_koin.presentation.AnimeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule= module {

    viewModel {
        AnimeViewModel(animeUseCase=get())
    }
}

val dataModule= module {
    single<AnimeRepository> {AnimeDataSource(animeApi=get())}
}
val domainModule= module {
    factory { AnimeUseCase(animeRepository=get()) }
}