package com.example.musicbox.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.musicbox.databinding.SearchItemsBinding
import com.example.musicbox.models.TextItems

class SearchAdapter(
    private val activity: Context,
    private val list: List<TextItems>
) : RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {
    class SearchViewHolder(val binding: SearchItemsBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val binding = SearchItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.apply {
            with(list[position]) {
                binding.apply {
                    tvTextView.text=title
                    tvTime.text =time
                   tvAddress.text = address
                    tvMusicType.text = musicType
                    tvLocation.text = location

                    Glide.with(activity)
                        .load(imageUrl)
                        .into(ivSearchImage)
                }
            }
        }
    }
}