package com.example.musicbox.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.musicbox.databinding.SavedEventsItemsBinding
import com.example.musicbox.models.SavedItems

class SavedEventsAdapter(
    private val activity: Context,
    private val list: List<SavedItems>
) : RecyclerView.Adapter<SavedEventsAdapter.SavedViewHolder>() {

    class SavedViewHolder(val binding: SavedEventsItemsBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SavedViewHolder {
       val binding=SavedEventsItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SavedViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return list.size
    }

    override fun onBindViewHolder(holder: SavedViewHolder, position: Int) {
        holder.apply {
            with(list[position]){
                binding.apply{
                    tvSavedEvent.text=title
                    tvMusicTypeText.text=musicType
                    tvDayTime.text=time

                    Glide.with(activity)
                        .load(imageUrl)
                        .into(ivImage)
            }

            }
        }

    }
}