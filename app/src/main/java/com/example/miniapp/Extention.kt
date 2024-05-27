package com.example.miniapp

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide

fun View.gone(){
    this.visibility = View.GONE
}

fun View.toVisible(){
    this.visibility = View.VISIBLE
}

fun View.inVisible(){
    this.visibility = View.INVISIBLE
}

fun ImageView.setImageUrl(url: String?){
    Glide
        .with(this)
        .load(url)
        .centerCrop()
        .placeholder(R.drawable.no_image)
        .into(this)
}