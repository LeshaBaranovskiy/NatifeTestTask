package com.example.natifetesttask.presentation.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.natifetesttask.domain.model.entity.Gif
import com.example.natifetesttask.presentation.viewholder.HorizontalGifsViewHolder

class HorizontalGifsAdapter(
    private val context: Context
): Adapter<HorizontalGifsViewHolder>() {
    var gifList: MutableList<Gif> = mutableListOf()

    fun addGifsToGifList(gifList: MutableList<Gif>) {
        this.gifList.addAll(gifList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalGifsViewHolder {
        return HorizontalGifsViewHolder.from(parent, context)
    }

    override fun getItemCount(): Int =
        gifList.size

    override fun onBindViewHolder(holder: HorizontalGifsViewHolder, position: Int) {
        holder.bind(gifList[position])
    }
}