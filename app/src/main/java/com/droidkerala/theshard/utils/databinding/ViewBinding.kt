/*
 * Copyright (c) 10/01/2019
 * Author : DroidFreak
 */

package com.droidkerala.theshard.utils.databinding

import android.graphics.drawable.Drawable
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.google.android.material.imageview.ShapeableImageView



//To change visibility of View based on passed data
@BindingAdapter("android:viewvisibility")
fun setViewVisibility(view: View, value: String?) {
    view.visibility = if (!value.isNullOrBlank()) View.VISIBLE else View.GONE
}

//To change visibility of Viewgroup based on passed data
@BindingAdapter("android:viewvisibility")
fun setViewVisibility(view: ViewGroup, value: String?) {
    view.visibility = if (!value.isNullOrBlank()) View.VISIBLE else View.GONE
}

//Load image with progress
@BindingAdapter("imageUrl", "progressbar")
fun loadImage(imageView: ImageView, imageUrl: String?, ProgressBar: ProgressBar?) {
    Glide.with(imageView.context).load("https://image.tmdb.org/t/p/w185$imageUrl")
        .listener(object : RequestListener<Drawable> {
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable>?,
                isFirstResource: Boolean
            ): Boolean {
                return false
            }

            override fun onResourceReady(
                resource: Drawable?,
                model: Any?,
                target: Target<Drawable>?,
                dataSource: DataSource?,
                isFirstResource: Boolean
            ): Boolean {
                ProgressBar?.visibility = View.GONE
                return false
            }
        }).into(imageView)
}


@BindingAdapter("imageShapeUrl")
fun loadImageShape(imageView: ShapeableImageView, imageShapeUrl: String?) {
    Glide.with(imageView.context).load(imageShapeUrl).into(imageView)
}