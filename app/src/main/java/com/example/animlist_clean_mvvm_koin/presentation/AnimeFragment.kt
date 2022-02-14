package com.example.animlist_clean_mvvm_koin.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.animlist_clean_mvvm_koin.R
import com.example.animlist_clean_mvvm_koin.databinding.FragmentAnimeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class AnimeFragment : Fragment() {

    private val animeViewModel: AnimeViewModel by viewModel()
    private var _binding : FragmentAnimeBinding? =null
    private val binding get() =_binding



    private val animeAdapter= AnimeAdapter()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding= FragmentAnimeBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setLayout()
        obserViewModel()
    }


    private fun setLayout() {
        binding?.coctailrecycler?.apply {
            setHasFixedSize(true)
            layoutManager=LinearLayoutManager(context)
            adapter=animeAdapter

        }

        animeViewModel.fetchAmimeApi()
    }

    private fun obserViewModel(){
        animeViewModel.animeList.observe(viewLifecycleOwner){
            var animeList= it.results

            if (animeList!=null){
                animeAdapter.anime=animeList
                animeAdapter.notifyDataSetChanged()
            }else{
                Toast.makeText(activity,"Error Occured",Toast.LENGTH_SHORT).show()
            }
        }

        animeViewModel.errorMsg.observe(viewLifecycleOwner){
            Toast.makeText(activity,it,Toast.LENGTH_SHORT).show()
        }
    }



}
