package com.example.opendota.ui.fragments.heroes

import android.util.Log
import com.example.opendota.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HeroesFragment :
    BaseFragment<HeroesViewModel, FragmentHeroesBinding>(R.layout.fragment_heroes) {

    override val binding by viewBinding(FragmentHeroesBinding::bind)
    override val viewModel: HeroesViewModel by viewModels()
    private val heroesAdapter = HeroesAdapter(
        this::onItemClick
    )

    override fun initialize() {
        setupRecyclerView()
    }

    private fun setupRecyclerView() = with(binding.recyclerHeroes) {
        layoutManager = LinearLayoutManager(requireContext())
        adapter = heroesAdapter
    }

    override fun setupSubscribes() {
        setupObserv()
    }

    private fun setupObserv() {
        viewModel.fetchHeroes().observe(viewLifecycleOwner) {
            when (it) {
                is Either.Left -> {
                    Log.e("anime", it.value)
                }
                is Either.Right -> {
                    Log.e("Anime", it.value.toString())
                    heroesAdapter.submitList(it.value)
                }
            }
        }
    }


    private fun onItemClick(id: Int) {
        findNavController().navigate(
            HeroesFragmentDirections.actionHeroesFragmentToHeroesDetailFragment(
                position = id
            )
        )
    }
}
