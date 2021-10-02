/*
 *
 *  * Created by Behruz on 10/1/21, 2:48 PM
 *  * Copyright (c) 2021 . All rights reserved.
 *  * Last modified 10/1/21, 2:48 PM
 *
 */

package tj.behruz.nasaapp.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import tj.behruz.nasaapp.R
import tj.behruz.nasaapp.databinding.HomeFragmentBinding
import tj.behruz.nasaapp.domain.models.NasaImages
import tj.behruz.nasaapp.domain.models.Resource
import tj.behruz.nasaapp.presentation.NasaImageAdapter

@AndroidEntryPoint
class HomeFragment: Fragment() {
    private lateinit var _binding: HomeFragmentBinding
    private val binding get() = _binding

    private val viewModel by viewModels<HomeViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = HomeFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.shimmer.startShimmer()
        viewModel.images.observe(viewLifecycleOwner) { result ->
            when (result) {
                is Resource.Success<*> -> {
                    val images = result.date as List<*>
                    binding.shimmer.apply {
                        stopShimmer()
                        visibility=View.GONE
                        binding.recyclerView.visibility=View.VISIBLE
                    }
                    binding.recyclerView.adapter = NasaImageAdapter(images as List<NasaImages>) {
                        val bundle = bundleOf()
                        bundle.putString("title", it.title)
                        bundle.putString("url", it.url)
                        findNavController().navigate(R.id.action_homeFragment_to_detailFragment, bundle)
                    }
                }
                is Resource.Error -> {

                }
                else -> {

                }
            }


        }
    }


}

