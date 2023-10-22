package com.cursillokotlin.superheroapp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/api.php/2416725148529127/search/{name}")
    suspend fun getSuerheroes(@Path("name")superheroNane:String): Response<SuperHeroDataResponse>
}