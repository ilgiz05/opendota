package com.example.opendota.ui.fragments.heroes

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HeroesViewModel @Inject constructor(private val repository: HeroesRepository) :
    BaseViewModel() {

    fun fetchHeroes() = repository.fetchHeroes()
}