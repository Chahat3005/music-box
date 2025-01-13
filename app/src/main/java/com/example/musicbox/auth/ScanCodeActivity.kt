package com.example.musicbox.auth

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.musicbox.R
import com.example.musicbox.dashboard.activities.MainActivity
import com.example.musicbox.dashboard.fragments.SettingsFragment
import com.example.musicbox.databinding.ActivityScanCodeBinding

class ScanCodeActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityScanCodeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScanCodeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        allClicks()
    }

    private fun allClicks() {
        binding.ivScanQR.setOnClickListener(this@ScanCodeActivity)
        binding.toolbar.ivBackButton.setOnClickListener(this)
        binding.toolbar.ivOption.setOnClickListener(this)
        binding.toolbar.tvTitle.visibility = View.GONE
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnClose -> {
                startActivity(Intent(this, MainActivity::class.java))
            }

            R.id.ivBackButton -> {
                onBackPressedDispatcher.onBackPressed()
            }
        }
    }

}