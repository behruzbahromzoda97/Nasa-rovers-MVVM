/*
 *
 *  * Created by Behruz on 10/1/21, 2:51 PM
 *  * Copyright (c) 2021 . All rights reserved.
 *  * Last modified 10/1/21, 2:51 PM
 *
 */

package tj.behruz.nasaapp.presentation.deatils

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import tj.behruz.nasaapp.R
import tj.behruz.nasaapp.databinding.DetailFragmentBinding

@AndroidEntryPoint
class DetailFragment: Fragment() {
    private lateinit var _binding: DetailFragmentBinding
    private val binding get() = _binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = DetailFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val title = requireArguments().getString("title")
        val url = requireArguments().getString("url")

        (activity as AppCompatActivity).supportActionBar?.apply {
            setTitle(title)
        }
        Glide.with(binding.imageView).load(url).placeholder(R.drawable.ic_loading_svgrepo_com).into(binding.imageView)

    }


}