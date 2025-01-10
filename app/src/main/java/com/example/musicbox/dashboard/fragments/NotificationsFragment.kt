package com.example.musicbox.dashboard.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.musicbox.R
import com.example.musicbox.adapter.NotificationsAdapter
import com.example.musicbox.dashboard.activities.MainActivity
import com.example.musicbox.databinding.FragmentNotificationsBinding
import com.example.musicbox.models.NotificationItem


class NotificationsFragment : Fragment(),View.OnClickListener {
    private lateinit var binding: FragmentNotificationsBinding
    private lateinit var notificationsAdapter: NotificationsAdapter
    private var notifications = ArrayList<NotificationItem>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        notifications.addAll(data())
        setAdapter()
        return (binding.root)
    }



    private fun setAdapter() {
        notificationsAdapter = NotificationsAdapter(notifications)
        binding.rvNotificationRecyclerView.adapter = notificationsAdapter

    }

    private fun data(): List<NotificationItem> {
        return listOf(
            NotificationItem(
                "New Event: Rock Night Extravaganza",
                "17m",
                R.drawable.image_profile
            ),
            NotificationItem(
                "Offer Redeemed: 20% Off Drinks",
                "2h",
                R.drawable.image_profile
            ),
            NotificationItem(
                "New Band Added: The Electric Vibes", "2h",
                R.drawable.image_profile
            ),
            NotificationItem(
                "Event Reminder: Jazz & Blues Night", "2h",
                R.drawable.image_profile
            ),
            NotificationItem(
                "Event Reminder: Jazz & Blues Night", "17m",
                R.drawable.image_profile
            ),
            NotificationItem(
                "Offer Redeemed: 20% Off Drinks", "2h",
                R.drawable.image_profile
            ),
            NotificationItem(
                "New Band Added: The Electric Vibes", "2h",
                R.drawable.image_profile
            ),
            NotificationItem(
                "Event Reminder: Jazz & Blues Night", "2h",
                R.drawable.image_profile
            ), NotificationItem(
                "Event Reminder: Jazz & Blues Night", "17m",
                R.drawable.image_profile
            ),
            NotificationItem(
                "Offer Redeemed: 20% Off Drinks", "2h",
                R.drawable.image_profile
            ),
            NotificationItem(
                "New Band Added: The Electric Vibes", "2h",
                R.drawable.image_profile
            ),
            NotificationItem(
                "Event Reminder: Jazz & Blues Night", "2h",
                R.drawable.image_profile
            ),

            )
    }

    override fun onClick(v: View) {
        when (v.id) {

            R.id.tvNotifications -> {
                startActivity(Intent(context, MainActivity::class.java))
            }

            R.id.ivBackButton -> {
                requireActivity().onBackPressedDispatcher.onBackPressed()
            }
        }
    }
}