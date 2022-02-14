package com.example.animlist_clean_mvvm_koin.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.animlist_clean_mvvm_koin.databinding.AnimeItemsBinding
import com.example.animlist_clean_mvvm_koin.domain.model.AnimsList
import com.squareup.picasso.Picasso

class AnimeAdapter:RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder>() {

    var anime: List<AnimsList> =ArrayList<AnimsList>()
    var picasso:Picasso = Picasso.get()
    class AnimeViewHolder(val binding: AnimeItemsBinding) :RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeAdapter.AnimeViewHolder {
      var binding =AnimeItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return AnimeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AnimeAdapter.AnimeViewHolder, position: Int) {
       holder.binding.tvTitle.text= anime[position].title
        holder.binding.tvType.text= anime[position].type
        holder.binding.tvRated.text= anime[position].rated

        var imageUri=anime[position].image_url
        picasso.load(imageUri)
            .into(holder.binding.imgAnime)
    }

    override fun getItemCount(): Int {
        return anime.size
    }
}