package com.example.animlist_clean_mvvm_koin.data

import com.example.animlist_clean_mvvm_koin.domain.model.Animes
import retrofit2.Response
import retrofit2.http.GET

interface AnimeApi {


    //https://api.jikan.moe/v3/search/anime?q=naruto
    @GET("v3/search/anime?q=naruto")
    suspend fun getAnimeData() : Response<Animes>

}