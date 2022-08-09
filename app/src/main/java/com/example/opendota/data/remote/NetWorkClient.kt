package com.example.opendota.data.remote

import com.example.opendota.data.remote.apiservices.HeroesApiService
import javax.inject.Inject

class NetWorkClient @Inject constructor(
    retrofitClient: RetrofitClient,
    okHttpClient: OkHttp
) {

    private val provideRetrofit = retrofitClient.provideRetrofit(okHttpClient.provideOkHttpClient())

    fun provideHeroesApiService() = provideRetrofit.create(HeroesApiService::class.java)
}