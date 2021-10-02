/*
 *
 *  * Created by Behruz on 10/2/21, 11:47 AM
 *  * Copyright (c) 2021 . All rights reserved.
 *  * Last modified 10/2/21, 11:47 AM
 *
 */

package tj.behruz.nasaapp.domain.extension

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import tj.behruz.nasaapp.R

fun ImageView.loadImage(url: String) {
    Glide.with(this).load(url)
        .diskCacheStrategy(DiskCacheStrategy.DATA)
        .placeholder(R.drawable.ic_loading_svgrepo_com). into(this)
}
