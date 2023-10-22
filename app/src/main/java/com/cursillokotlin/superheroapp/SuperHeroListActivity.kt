package com.cursillokotlin.superheroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import com.cursillokotlin.kotlin.databinding.ActivitySuperHeroListBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SuperHeroListActivity : AppCompatActivity() {


private lateinit var binding: ActivitySuperHeroListBinding
private lateinit var retrofit: Retrofit
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuperHeroListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        retrofit = getRetrofit()
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
        binding.pressedBar.isVisible = true
        //hilo secundario
        CoroutineScope(Dispatchers.IO).launch {
            val myResponse = retrofit.create(ApiService::class.java).getSuerheroes(query)

            if(myResponse.isSuccessful){
                Log.i("SuperHero", "funciona:)")
                val response: SuperHeroDataResponse? =  myResponse.body()
                if(response!= null){
                    Log.i("SuperHero", response.toString())

                   runOnUiThread {
                       binding.pressedBar.isVisible = false
                   }

                }
            }else{
                Log.i("SuperHero", "NO funciona:(")

            }
        }
    }

    private fun getRetrofit():Retrofit{
        return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}