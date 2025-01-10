package com.example.musicbox.dashboard.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.musicbox.R
import com.example.musicbox.databinding.FragmentSettingBinding

class SettingsFragment : Fragment() ,View.OnClickListener {
    private lateinit var binding: FragmentSettingBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSettingBinding.inflate(inflater, container, false)
        allClicks()
        return (binding.root)
    }
    private fun allClicks() {
        binding.tvEditProfile.setOnClickListener(this@SettingsFragment)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.ivBackButton -> {
                requireActivity().onBackPressedDispatcher.onBackPressed()
            }
        }
    }
}