package com.cursillokotlin.superheroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import com.cursillokotlin.kotlin.databinding.ActivitySuperHeroListBinding

class SuperHeroListActivity : AppCompatActivity() {


private lateinit var binding: ActivitySuperHeroListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuperHeroListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()

    }

    private fun initUI() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            //se llama automaticamente cuando le demos al boton de buscar
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchByName(query.orEmpty())

                return false
            }

            override fun onQueryTextChange(newText: String?)= false


        })
    }

    private fun searchByName(query: String) {

    }
}