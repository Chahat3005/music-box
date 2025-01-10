package com.example.musicbox.dashboard.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import com.example.musicbox.R
import com.example.musicbox.dashboard.fragments.*
import com.example.musicbox.databinding.ActivityMainBinding
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var drawerLayout: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        click()
        setToolbar()
        setDrawerNavigation()
        setBottomNavigation()
        loadFragment(SearchFragment())
    }

    private fun click() {
        binding.toolbar.ivOption.setOnClickListener(this)
        binding.toolbar.ivBackButton.setOnClickListener(this)
    }

    private fun setToolbar() {
        binding.toolbar.ivSearchOption.visibility = View.GONE
    }

    private fun setDrawerNavigation() {
        drawerLayout = ActionBarDrawerToggle(
            this,
            binding.dlDrawerLayout,
            R.string.nav_open,
            R.string.nav_close
        )
        binding.dlDrawerLayout.addDrawerListener(drawerLayout)
        drawerLayout.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.nvSideNavigation.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_home -> loadFragment(SearchFragment())
                R.id.navigation_calender -> loadFragment(CalenderFragment())
                R.id.navigation_notifications -> loadFragment(NotificationsFragment())
                R.id.navigation_setting -> loadFragment(SettingsFragment())
                R.id.navigation_profile -> loadFragment(ProfileFragment())
            }
            binding.dlDrawerLayout.closeDrawers()
            true
        }
    }

    override fun onOptionsItemSelected(item: android.view.MenuItem): Boolean {
        if (drawerLayout.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setBottomNavigation() {
        binding.bnBottomNavigation.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_home -> {
                    loadFragment(SearchFragment())
                }

                R.id.navigation_calender -> {
                    loadFragment(CalenderFragment())
                }

                R.id.navigation_notifications -> {
                    loadFragment(NotificationsFragment())
                    binding.toolbar.tvTitle.text = getString(R.string.notifications)
                }

                R.id.navigation_setting -> {
                    loadFragment(SettingsFragment())
                    binding.toolbar.tvTitle.visibility=View.GONE
                }

                R.id.navigation_profile -> {
                    loadFragment(ProfileFragment())
                }
            }
            true
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.flFrameContainer.id, fragment)
            .commit()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.ivOption -> {
                binding.dlDrawerLayout.openDrawer(binding.nvSideNavigation)
            }

            R.id.ivBackButton -> {
                onBackPressedDispatcher.onBackPressed()
            }
        }
    }
}
