package com.example.animlist_clean_mvvm_koin.data

import com.example.animlist_clean_mvvm_koin.domain.model.Animes
import com.example.animlist_clean_mvvm_koin.domain.repository.AnimeRepository
import retrofit2.Response

class AnimeDataSource(private val animeApi: AnimeApi) : AnimeRepository {
    override suspend fun getAnimeData(): Response<Animes> {
       return animeApi.getAnimeData()
    }
}