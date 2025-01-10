package com.example.musicbox.auth

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.musicbox.R
import com.example.musicbox.adapter.SearchesAdapter
import com.example.musicbox.dashboard.activities.MainActivity
import com.example.musicbox.databinding.ActivitySearchesBinding
import com.example.musicbox.models.SearchItem

class SearchesActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivitySearchesBinding
    private lateinit var gridAdapter: SearchesAdapter
    private var grid = ArrayList<SearchItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setAdapter()
        grid.addAll(items())
    }

    private fun setAdapter() {
        binding.tvGeneres.setOnClickListener(this@SearchesActivity)
        binding.toolbar.ivBackButton.setOnClickListener(this)
        binding.rvGridRecycleView.layoutManager = GridLayoutManager(this, 3)
        gridAdapter = SearchesAdapter(grid)
        binding.toolbar.ivOption.setOnClickListener(this)
        binding.rvGridRecycleView.adapter = gridAdapter
        binding.toolbar.tvTitle.text = getString(R.string.search)
        binding.toolbar.ivSearchOption.visibility = View.GONE
    }

    private fun items(): List<SearchItem> {
        return listOf(
            SearchItem("African"),
            SearchItem("Asian"),
            SearchItem("Avantgrade"),
            SearchItem("Blues"),
            SearchItem("Country"),
            SearchItem("Electronic"),
            SearchItem("Folk"),
            SearchItem("Hip Hop"),
            SearchItem("Jazz"),
        )
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.tvGeneres -> {
                startActivity(Intent(this, MainActivity::class.java))
            }

            R.id.ivOption -> {
                startActivity(Intent(this, SearchBarActivity::class.java))
            }

            R.id.ivBackButton -> {
                onBackPressedDispatcher.onBackPressed()
            }
        }
    }
}
