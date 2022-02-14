package com.example.animlist_clean_mvvm_koin.domain.useCase

import com.example.animlist_clean_mvvm_koin.domain.model.Animes
import com.example.animlist_clean_mvvm_koin.domain.repository.AnimeRepository
import retrofit2.Response

class AnimeUseCase(private val animeRepository: AnimeRepository) {

    suspend operator fun invoke(): Response<Animes>{
        return animeRepository.getAnimeData()
    }
}