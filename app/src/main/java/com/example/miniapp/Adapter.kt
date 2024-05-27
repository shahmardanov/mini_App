package com.example.miniapp

import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("setImageFromUrl")
fun setImageUrl(imageView: ImageView, url: String?) {
    url?.let {
        imageView.setImageUrl(it)
    }
}