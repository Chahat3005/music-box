package com.example.musicbox.auth

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.musicbox.R
import com.example.musicbox.dashboard.fragments.NotificationsFragment
import com.example.musicbox.databinding.ActivitySearchBarBinding

class SearchBarActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivitySearchBarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        clicks()
    }

    private fun clicks() {
        binding.tvSearches.setOnClickListener(this@SearchBarActivity)
        binding.ivCross.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tvSearches -> {
                startActivity(Intent(this, EventsAddedActivity::class.java))
            }
            R.id.ivSearchOption -> {
                startActivity(Intent(this,SearchesActivity::class.java))
            }

            R.id.ivCross -> {
                onBackPressedDispatcher.onBackPressed()
            }
        }
    }


}