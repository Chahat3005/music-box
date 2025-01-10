package com.example.musicbox.dashboard.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.musicbox.R
import com.example.musicbox.adapter.MusicVenueAdapter
import com.example.musicbox.auth.EventsAddedActivity
import com.example.musicbox.auth.SearchBarActivity
import com.example.musicbox.databinding.FragmentProfileBinding
import com.example.musicbox.models.MusicBand

class ProfileFragment : Fragment(), View.OnClickListener {
    private lateinit var binding: FragmentProfileBinding
    private lateinit var music: MusicVenueAdapter
    private var profileList = ArrayList<MusicBand>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        click()
        profileList.addAll(data())
        setAdapter()
        return (binding.root)
    }

    private fun click() {
        binding.btnSave.setOnClickListener(this@ProfileFragment)
    }


    private fun setAdapter() {
        music = MusicVenueAdapter(profileList)
        binding.rvMusic.layoutManager = GridLayoutManager(context, 2)
        binding.rvMusic.adapter = music
    }

    private fun data(): List<MusicBand> {
        return listOf(
            MusicBand(
                "Rock",
                "Jazz",
                R.drawable.edittext_background
            ),
        )
    }

    private fun checkValidation(): Boolean {
        if (binding.etName.text!!.isEmpty()) {
            Toast.makeText(context, "Please enter the venue name", Toast.LENGTH_SHORT).show()
            return false
        } else if (binding.etVenueName.text!!.isEmpty()) {
            Toast.makeText(context, "Please enter your venue name", Toast.LENGTH_SHORT).show()
            return false
        } else if (binding.etLocation.text!!.isEmpty()) {
            Toast.makeText(context, "Please enter your location", Toast.LENGTH_SHORT).show()
            return false
        } else if (binding.etCapacity.text!!.isEmpty()) {
            Toast.makeText(context, "Please enter the number of people", Toast.LENGTH_SHORT).show()
            return false
        } else if (binding.etBio.text!!.isEmpty()) {
            Toast.makeText(context, "Please enter bio", Toast.LENGTH_SHORT).show()
            return false
        } else if (binding.etEventCalender.text!!.isEmpty()) {
            Toast.makeText(context, "Please enter the date", Toast.LENGTH_SHORT).show()
            return false
        } else if (binding.etAdd.text!!.isEmpty()) {
            Toast.makeText(context, "Click on add button to add the music", Toast.LENGTH_SHORT)
                .show()
            return false
        }
        return true
    }
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnSave -> {
                if (checkValidation()) {
                    startActivity(Intent(context, EventsAddedActivity::class.java))
                }

            }

            R.id.ivBackButton -> {
                requireActivity().onBackPressedDispatcher.onBackPressed()
            }
        }
    }

}