package com.example.natifetesttask.presentation.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.natifetesttask.domain.model.entity.Gif
import com.example.natifetesttask.presentation.viewholder.VerticalGifsViewHolder

class VerticalGifsAdapter(
    private val context: Context,
    private val onMainLayoutClick: (position: Int) -> Unit,
    private val onDeleteClick: (position: Int, gifId: String) -> Unit
): Adapter<VerticalGifsViewHolder>() {
    var gifList: MutableList<Gif> = mutableListOf()

    fun addGifsToGifList(gifList: MutableList<Gif>) {
        this.gifList.addAll(gifList)
        notifyItemRangeChanged(0, itemCount)
    }

    fun removeAllGifs() {
        this.gifList.clear()
        notifyDataSetChanged()
    }

    fun removeGif(position: Int) {
        this.gifList.removeAt(position)
        notifyItemRemoved(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VerticalGifsViewHolder {
        return VerticalGifsViewHolder.from(parent, context, onMainLayoutClick, onDeleteClick)
    }

    override fun getItemCount(): Int = gifList.size

    override fun onBindViewHolder(holder: VerticalGifsViewHolder, position: Int) {
        holder.bind(gifList[position], position)
    }
}