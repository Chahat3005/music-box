package com.example.musicbox.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.musicbox.databinding.ListWelcomeTextBinding
import com.example.musicbox.models.WelcomeModel

class WelcomeTextAdapter(
    private val list: List<WelcomeModel>
) :
    RecyclerView.Adapter<WelcomeTextAdapter.MyViewModel>() {

    class MyViewModel(val binding: ListWelcomeTextBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewModel {
        val binding =
            ListWelcomeTextBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewModel(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewModel, position: Int) {

        holder.binding.tvWelcomeText.text = list[position].title
    }

}