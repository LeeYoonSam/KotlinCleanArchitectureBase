package com.test.main

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.test.R
import com.test.model.Photo

@BindingAdapter(value = ["photoItems"])
fun photoItems(recyclerView: RecyclerView, list: List<Photo>?) {
    list ?: return

    if (recyclerView.adapter == null) {
        recyclerView.adapter = PhotoAdapter()
    }

    (recyclerView.adapter as PhotoAdapter).apply {
        val take = list.take(10)
        submitList(take)
    }
}

@BindingAdapter(value = ["photoThumbnail"])
fun photoThumbnail(imageView: ImageView, url: String?) {
    if(url == null || url.isEmpty()) return

    Glide.with(imageView.context)
        .load(url)
        .centerCrop()
        .placeholder(R.drawable.ic_launcher_foreground)
        .into(imageView)
}