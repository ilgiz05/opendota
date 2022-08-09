package com.example.opendota.data.remote.apiservices

import com.example.opendota.models.DetailHeroModel
import com.example.opendota.models.HeroesModel
import retrofit2.http.GET
import retrofit2.http.Path

interface HeroesApiService {

    @GET("heroes")
    suspend fun fetchHeroes(): List<HeroesModel>

    @GET("heroes/{hero_id}/matches")
    suspend fun fetchHeroesId(
        @Path("hero_id") id: Int
    ): List<DetailHeroModel>
}