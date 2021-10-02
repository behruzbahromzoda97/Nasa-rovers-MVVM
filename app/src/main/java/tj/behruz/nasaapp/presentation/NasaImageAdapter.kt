/*
 *
 *  * Created by Behruz on 10/2/21, 4:07 PM
 *  * Copyright (c) 2021 . All rights reserved.
 *  * Last modified 10/2/21, 4:07 PM
 *
 */

package tj.behruz.nasaapp.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import tj.behruz.nasaapp.databinding.NasaImageItemBinding
import tj.behruz.nasaapp.domain.extension.loadImage
import tj.behruz.nasaapp.domain.models.NasaImages

class NasaImageAdapter(private val images: List<NasaImages>, val itemHandler: (NasaImages) -> Unit): RecyclerView.Adapter<NasaImageAdapter.NasaImageItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NasaImageItemViewHolder {
        val binding = NasaImageItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NasaImageItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NasaImageItemViewHolder, position: Int) {
        val currentImage = images[position]
        holder.setImage(currentImage.url)
        holder.itemView.setOnClickListener {
            itemHandler.invoke(currentImage)
        }
    }

    override fun getItemCount() = images.size

    inner class NasaImageItemViewHolder(private val binding: NasaImageItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun setImage(url: String) {
            binding.image.loadImage(url)
        }
    }


}