package com.example.animlist_clean_mvvm_koin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController

class MainActivity : AppCompatActivity() {

    var navController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = findNavController(R.id.navHostFragment)

        supportActionBar?.elevation = 0F
    }

    override fun onSupportNavigateUp() = findNavController(R.id.navHostFragment).navigateUp()
}