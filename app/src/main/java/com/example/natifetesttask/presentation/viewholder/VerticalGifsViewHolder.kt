package com.example.natifetesttask.presentation.viewholder

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.natifetesttask.databinding.ItemVerticalGifsBinding
import com.example.natifetesttask.domain.model.entity.Gif
import com.facebook.shimmer.Shimmer
import com.facebook.shimmer.ShimmerDrawable

class VerticalGifsViewHolder(
    private val context: Context,
    private val binding: ItemVerticalGifsBinding,
    private val onMainLayoutClick: (position: Int) -> Unit
): ViewHolder(binding.root) {
    fun bind(gif: Gif, position: Int) {
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

        binding.tvImageTitle.text = gif.title

        Glide
            .with(context)
            .asGif()
            .load(gif.images.original.url)
            .placeholder(shimmerDrawable)
            .into(binding.ivMainImage)

        binding.mainLayout.setOnClickListener {
            onMainLayoutClick.invoke(position)
        }
    }

    companion object {
        fun from(parent: ViewGroup, context: Context, onMainLayoutClick: (position: Int) -> Unit): VerticalGifsViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = ItemVerticalGifsBinding.inflate(inflater, parent, false)
            return VerticalGifsViewHolder(context, binding, onMainLayoutClick)
        }
    }
}