package com.example.musicbox.auth

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.musicbox.R
import com.example.musicbox.dashboard.activities.MainActivity
import com.example.musicbox.databinding.ActivitySubscriptionBinding

class SubscriptionActivity : AppCompatActivity(),View.OnClickListener {
    private lateinit var binding:ActivitySubscriptionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySubscriptionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        clicks()
    }

    private fun clicks(){
        binding.btnSubscribe1.setOnClickListener(this@SubscriptionActivity)
        binding.btnSubscribe2.setOnClickListener(this@SubscriptionActivity)
        binding.toolbar.ivBackButton.setOnClickListener(this)
        binding.toolbar.tvTitle.visibility=View.GONE
    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.btnSubscribe1 -> {
                startActivity(Intent(this, MainActivity::class.java))
            }
            R.id.btnSubscribe2 -> {
                startActivity(Intent(this, MainActivity::class.java))
            }
            R.id.ivBackButton -> {
                onBackPressedDispatcher.onBackPressed()
            }
            R.id.ivOption -> {
                startActivity(Intent(this,SearchBarActivity::class.java))
            }
        }
    }


}