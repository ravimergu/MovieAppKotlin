package com.example.myapplication.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager

object ImageUtils {

    @JvmStatic
    @BindingAdapter("imageUrl","requestManager")
    fun setImageUrl(imageView: ImageView, imageUrl: String,requestManager: RequestManager) {
        requestManager.load(imageUrl).into(imageView)
    }

}