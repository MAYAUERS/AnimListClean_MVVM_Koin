package com.example.animlist_clean_mvvm_koin.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animlist_clean_mvvm_koin.domain.model.Animes
import com.example.animlist_clean_mvvm_koin.domain.useCase.AnimeUseCase
import kotlinx.coroutines.launch

open class AnimeViewModel(private val animeUseCase: AnimeUseCase):ViewModel() {

    open val animeList :LiveData<Animes> get()= _animeList
    private val _animeList =MutableLiveData<Animes> ()

     open val errorMsg :LiveData<String> get()= _errorMsg
    private val _errorMsg =MutableLiveData<String> ()

    fun fetchAmimeApi(){

        viewModelScope.launch {

            var response=animeUseCase.invoke()

            if(response.isSuccessful){
                _animeList.value=response.body()
            }else{
                _errorMsg.value=response.errorBody().toString()
            }

        }

    }

}