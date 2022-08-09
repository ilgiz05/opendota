package com.example.opendota.data.repository

import androidx.lifecycle.liveData
import com.example.opendota.Either
import com.example.opendota.data.remote.apiservices.HeroesApiService
import kotlinx.coroutines.Dispatchers
import java.io.IOException
import javax.inject.Inject

class HeroesRepository @Inject constructor(private val apiService: HeroesApiService) {

    fun fetchHeroes() = liveData (Dispatchers.IO) {
        try {
            emit(Either.Right(apiService.fetchHeroes()))
        } catch (ioException: IOException) {
            emit(Either.Left(ioException.localizedMessage))
        }
    }

    fun fetchHeroesId(id: Int) = liveData(Dispatchers.IO) {
        try {
            emit(Either.Right(apiService.fetchHeroesId(id = id)))
        } catch (ioException: IOException) {
            emit(Either.Left(ioException.localizedMessage))
        }
    }
}