package com.example.animlist_clean_mvvm_koin.domain.repository

import com.example.animlist_clean_mvvm_koin.domain.model.Animes
import retrofit2.Response

interface AnimeRepository {

    suspend fun getAnimeData() : Response<Animes>
}