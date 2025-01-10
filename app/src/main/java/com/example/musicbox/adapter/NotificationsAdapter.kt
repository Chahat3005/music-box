package com.example.musicbox.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.musicbox.databinding.NotificationTextBinding
import com.example.musicbox.models.NotificationItem

class NotificationsAdapter(
    private val list: List<NotificationItem>
) :
    RecyclerView.Adapter<NotificationsAdapter.NotificationViewHolder>() {

    class NotificationViewHolder(val binding: NotificationTextBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NotificationViewHolder {
        val binding =
            NotificationTextBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NotificationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        holder.binding.tvNotifications.text = list[position].title
        holder.binding.tvTime.text = list[position].time

    }

    override fun getItemCount(): Int {
        return list.size
    }

}
