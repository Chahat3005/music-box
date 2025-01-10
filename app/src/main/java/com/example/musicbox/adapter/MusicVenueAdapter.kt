package com.example.musicbox.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.musicbox.databinding.MusicItemBinding
import com.example.musicbox.models.MusicBand

class MusicVenueAdapter(
    private val list: List<MusicBand>
) :
    RecyclerView.Adapter<MusicVenueAdapter.MusicViewHolder>() {

    class MusicViewHolder(val binding: MusicItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        val binding = MusicItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MusicViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        val musicBand = list[position]
        holder.binding.tvMusicTypeText.text = musicBand.title
        holder.binding.tvMusicText.text = musicBand.text

    }
}