package com.example.animlist_clean_mvvm_koin.domain.model

data class Animes(var results:List<AnimsList>)
data class AnimsList(var type:String, var title:String, var rated:String,var image_url:String)

