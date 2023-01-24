package com.example.natifetesttask.presentation.viewholder

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.natifetesttask.databinding.ItemHorizontalGifsBinding
import com.example.natifetesttask.domain.model.entity.Gif
import com.facebook.shimmer.Shimmer
import com.facebook.shimmer.ShimmerDrawable

class HorizontalGifsViewHolder(
    private val binding: ItemHorizontalGifsBinding,
    private val context: Context
): ViewHolder(binding.root) {
    fun bind(gif: Gif) {
        val shimmer = Shimmer.AlphaHighlightBuilder()
            .setDuration(1800)
            .setBaseAlpha(0.7f)
            .setHighlightAlpha(0.6f)
            .setDirection(Shimmer.Direction.LEFT_TO_RIGHT)
            .setAutoStart(true)
            .build()

        val shimmerDrawable = ShimmerDrawable().apply {
            setShimmer(shimmer)
        }

        binding.tvGifTitle.text = gif.title

        Glide
            .with(context)
            .asGif()
            .load(gif.images.original.url)
            .placeholder(shimmerDrawable)
            .into(binding.ivGif)
    }

    companion object {
        fun from(parent: ViewGroup, context: Context): HorizontalGifsViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = ItemHorizontalGifsBinding.inflate(inflater, parent, false)
            return HorizontalGifsViewHolder(binding, context)
        }
    }
}