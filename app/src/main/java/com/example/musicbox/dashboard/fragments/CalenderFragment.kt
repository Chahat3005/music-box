package com.example.musicbox.dashboard.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.musicbox.R
import com.example.musicbox.adapter.SavedEventsAdapter
import com.example.musicbox.auth.SearchBarActivity
import com.example.musicbox.databinding.FragmentCalenderBinding
import com.example.musicbox.models.SavedItems


class CalenderFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentCalenderBinding
    private lateinit var savedEventsAdapter: SavedEventsAdapter
    private var savedEventsList = ArrayList<SavedItems>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCalenderBinding.inflate(inflater, container, false)
        savedEventsList.addAll(data())
        setAdapter()
        return (binding.root)
    }


    private fun setAdapter() {
        savedEventsAdapter = SavedEventsAdapter(requireContext(), savedEventsList)
        binding.rvSavedEvents.adapter = savedEventsAdapter
    }

    fun data(): List<SavedItems> {
        return listOf(
            SavedItems(
                "Smooth Jazz Ensemble",
                "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.dreamstime.com%2Fphotos-images%2Fdance-club.html&psig=AOvVaw0jVETixTIgLIAFbuzk-pyJ&ust=1736587516607000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCLCs1OHq6ooDFQAAAAAdAAAAABAE",
                "July 20, 2024, 7:30 PM",
                "Jazz",
            ),
            SavedItems(
                "Smooth Jazz Ensemble",
                "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.dreamstime.com%2Fphotos-images%2Fdance-club.html&psig=AOvVaw0jVETixTIgLIAFbuzk-pyJ&ust=1736587516607000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCLCs1OHq6ooDFQAAAAAdAAAAABAE",
                "July 20, 2024, 7:30 PM",
                "Jazz",
            ),
            SavedItems(
                "Smooth Jazz Ensemble",
                "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.dreamstime.com%2Fphotos-images%2Fdance-club.html&psig=AOvVaw0jVETixTIgLIAFbuzk-pyJ&ust=1736587516607000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCLCs1OHq6ooDFQAAAAAdAAAAABAE",
                "July 20, 2024, 7:30 PM",
                "Jazz",
            ),
            SavedItems(
                "Smooth Jazz Ensemble",
                "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.dreamstime.com%2Fphotos-images%2Fdance-club.html&psig=AOvVaw0jVETixTIgLIAFbuzk-pyJ&ust=1736587516607000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCLCs1OHq6ooDFQAAAAAdAAAAABAE",
                "July 20, 2024, 7:30 PM",
                "Jazz",
            ),
            SavedItems(
                "Smooth Jazz Ensemble",
                "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.dreamstime.com%2Fphotos-images%2Fdance-club.html&psig=AOvVaw0jVETixTIgLIAFbuzk-pyJ&ust=1736587516607000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCLCs1OHq6ooDFQAAAAAdAAAAABAE",
                "July 20, 2024, 7:30 PM",
                "Jazz",
            ),
            SavedItems(
                "Smooth Jazz Ensemble",
                "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.dreamstime.com%2Fphotos-images%2Fdance-club.html&psig=AOvVaw0jVETixTIgLIAFbuzk-pyJ&ust=1736587516607000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCLCs1OHq6ooDFQAAAAAdAAAAABAE",
                "July 20, 2024, 7:30 PM",
                "Jazz",
            ),
        )
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.ivBackButton -> {
                requireActivity().onBackPressedDispatcher.onBackPressed()
            }

            R.id.ivSearchOption -> {
                startActivity(Intent(context, SearchFragment::class.java))
            }
        }
    }

}
