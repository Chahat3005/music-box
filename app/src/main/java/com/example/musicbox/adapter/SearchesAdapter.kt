package com.example.musicbox.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.musicbox.R
import com.example.musicbox.models.SearchItem

class SearchesAdapter(
    private val list: List<SearchItem>
) :
    RecyclerView.Adapter<SearchesAdapter.SearchViewHolder>() {

    class SearchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemTitle: TextView = itemView.findViewById(R.id.tvSearch)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.grid_search, parent, false)
        return SearchViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val gridItem = list[position]
        holder.itemTitle.text = gridItem.title
    }
}