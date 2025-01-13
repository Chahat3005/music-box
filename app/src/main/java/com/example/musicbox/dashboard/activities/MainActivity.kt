package com.example.musicbox.dashboard.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import com.example.musicbox.R
import com.example.musicbox.dashboard.fragments.*
import com.example.musicbox.databinding.ActivityMainBinding
import androidx.fragment.app.Fragment
import com.example.musicbox.auth.LoginActivity
import com.example.musicbox.network.ApiInterface
import com.example.musicbox.models.AuthResponse
import com.example.musicbox.network.RetrofitClient
import okhttp3.Callback
import retrofit2.Call
import retrofit2.Response

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
        binding.nvSideNavigation.setOnClickListener(this)
    }

    private fun setToolbar() {
        binding.toolbar.ivSearchOption.visibility = View.GONE
    }

    private fun logoutApi() {
        val apiInterface = RetrofitClient.getInstance().create(ApiInterface::class.java)
        apiInterface.logoutApi()
            .enqueue(object : retrofit2.Callback<AuthResponse> {
                override fun onResponse(
                    call: Call<AuthResponse>,
                    response: Response<AuthResponse>
                ) {
                    if (response.code() == 200 || response.code() == 201) {
                        startActivity(Intent(this@MainActivity, LoginActivity::class.java))
                        Toast.makeText(this@MainActivity, "Logout Successfully", Toast.LENGTH_SHORT)
                            .show()
                    }
                }

                override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                    Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
                }

            }
            )


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

                R.id.navigation_home -> Toast.makeText(this,"sign yoddjc",Toast.LENGTH_SHORT).show()
                R.id.navigation_notifications -> loadFragment(NotificationsFragment())
                R.id.navigation_setting -> loadFragment(SettingsFragment())
                R.id.navigation_profile -> loadFragment(ProfileFragment())
                R.id.navigation_signOut -> logoutApi()

            }
            binding.dlDrawerLayout.closeDrawers()
            true
        }
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
                    binding.toolbar.tvTitle.visibility = View.GONE
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

            R.id.tvSignOut -> {
                logoutApi()
            }

            R.id.ivBackButton -> {
                onBackPressedDispatcher.onBackPressed()
            }
        }
    }
}
