package com.example.opendota.ui.fragments.details

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HeroesDetailViewModel @Inject constructor(private val repository: HeroesRepository) :
    BaseViewModel() {

    fun fetchHeroesId(position: Int) = repository.fetchHeroesId(position)
}