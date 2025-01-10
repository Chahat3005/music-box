package com.example.musicbox.dashboard.fragments

import com.example.musicbox.adapter.SearchAdapter
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.musicbox.R
import com.example.musicbox.databinding.FragmentSearchBinding
import com.example.musicbox.models.TextItems

class SearchFragment : Fragment(),View.OnClickListener {
    private lateinit var binding: FragmentSearchBinding
    private lateinit var searchItems : SearchAdapter
    private var list=ArrayList<TextItems>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        list.addAll(data())
        setAdapter()
        return (binding.root)
    }
    private fun setAdapter(){
        searchItems= SearchAdapter(requireContext(),list)
        binding.rvSearch.adapter=searchItems
    }

    fun data() :List<TextItems>{
        return listOf(
            TextItems(
                "Smooth Jazz Ensemble",
                "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.dreamstime.com%2Fphotos-images%2Fdance-club.html&psig=AOvVaw0Lmj5tQCgt7I530dkthxLH&ust=1736088232775000&source=images&cd=vfe&opi=89978449&ved=0CBQQjRxqFwoTCMjXquam3IoDFQAAAAAdAAAAABAE",
                "July 20, 2024, 7:30 PM",
                "101 Moonlight Rd, New York, NY",
                "Moonlight Lounge",
                "Jazz"
                ),
            TextItems(
                "Jazz & Soul Collective",
                "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.dreamstime.com%2Fphotos-images%2Fdance-club.html&psig=AOvVaw0Lmj5tQCgt7I530dkthxLH&ust=1736088232775000&source=images&cd=vfe&opi=89978449&ved=0CBQQjRxqFwoTCMjXquam3IoDFQAAAAAdAAAAABAE",
                "July 20, 2024, 7:30 PM",
                "789 Blue Ave, New York, NY",
                "The Blue Door",
                "Jazz",
            ),
        )
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.ivSearchOption-> {
                startActivity(Intent(context,CalenderFragment::class.java))
            }
            R.id.ivBackButton-> {
                requireActivity().onBackPressedDispatcher.onBackPressed()
            }
        }
    }

}


