package com.example.musicbox.auth

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.musicbox.R
import com.example.musicbox.adapter.WelcomeTextAdapter
import com.example.musicbox.databinding.ActivityWelcomeBinding
import com.example.musicbox.models.WelcomeModel

class WelcomeActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityWelcomeBinding
    private lateinit var welcomeAdapter: WelcomeTextAdapter
    private var list = ArrayList<WelcomeModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        list.addAll(items())
        textAdapter()
        clicks()
    }

    private fun clicks() {
        binding.btnNext.setOnClickListener(this@WelcomeActivity)
        binding.toolbar.ivOption.setOnClickListener(this)
        binding.toolbar.ivBackButton.setOnClickListener(this)
        binding.toolbar.tvTitle.visibility = View.GONE
        binding.toolbar.ivSearchOption.visibility = View.GONE
    }

    private fun textAdapter() {
        welcomeAdapter = WelcomeTextAdapter(list)
        binding.rvRecycleView.adapter = welcomeAdapter
    }

    private fun items(): List<WelcomeModel> {
        return listOf(
            WelcomeModel("AfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfrican"),
            WelcomeModel("AfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfricanAfrican"),

            )
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnNext -> {
                startActivity(Intent(this, SearchesActivity::class.java))
            }


            R.id.ivBackButton -> {
                onBackPressedDispatcher.onBackPressed()
            }
        }
    }

}
