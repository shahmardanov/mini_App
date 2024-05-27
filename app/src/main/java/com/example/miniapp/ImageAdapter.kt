package com.example.miniapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.miniapp.databinding.ImageCardBinding

class ImageAdapter : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    val imageList = arrayListOf<String>()

    inner class ImageViewHolder(val imageBinding: ImageCardBinding) :
        RecyclerView.ViewHolder(imageBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = ImageCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val item = imageList[position]
        holder.imageBinding.item = item
    }

    fun updateMyList(newList: List<String>) {
        imageList.clear()
        imageList.addAll(newList)
        notifyDataSetChanged()
    }
}