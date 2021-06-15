package com.rohitthebest.imagesliderusingviewpager2.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.rohitthebest.imagesliderusingviewpager2.R
import com.rohitthebest.imagesliderusingviewpager2.databinding.ImageItemBinding

class ViewPagerAdapter(private val imageUrlList: List<String>) :
    RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>() {

    inner class ViewPagerViewHolder(val binding: ImageItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun setData(imageUrl: String) {

            Glide.with(binding.root.context)
                .load(imageUrl)
                .error(R.drawable.ic_baseline_error_outline_24)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(binding.ivImage)
        }

    }

    override fun getItemCount(): Int = imageUrlList.size


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {

        val binding = ImageItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ViewPagerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {

        holder.setData(imageUrlList[position])
    }

}
