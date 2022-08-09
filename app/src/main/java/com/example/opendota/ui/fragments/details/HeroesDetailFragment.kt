package com.example.opendota.ui.fragments.details

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.opendota.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HeroesDetailFragment : Fragment {

    private val binding by viewBinding(FragmentHeroesDetailBinding::bind)
    private val viewModel: HeroesDetailViewModel by viewModels()
    private val args by navArgs<HeroesDetailFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()
    }

    private fun getData() {
        viewModel.fetchHeroesId(args.position).observe(viewLifecycleOwner) {
            when (it) {
                is Either.Left -> {
                    Log.e("anime", it.value.toString())
                }
                is Either.Right -> {
                    it.value.forEach { detailHeroModel ->
                        binding.nameDetailHeroes.text = detailHeroModel.leagueName
                    }
                }
            }
        }
    }
}