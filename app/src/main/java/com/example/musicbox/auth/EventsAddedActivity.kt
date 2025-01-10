package com.example.musicbox.auth

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.musicbox.R
import com.example.musicbox.databinding.ActivityEventsAddedBinding

class EventsAddedActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityEventsAddedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEventsAddedBinding.inflate(layoutInflater)
        setContentView(binding.root)
        clicks()
    }

    private fun clicks() {
        binding.btnNewSearch.setOnClickListener(this@EventsAddedActivity)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnNewSearch -> {
                startActivity(Intent(this, SubscriptionActivity
                ::class.java))
            }
        }


    }
}