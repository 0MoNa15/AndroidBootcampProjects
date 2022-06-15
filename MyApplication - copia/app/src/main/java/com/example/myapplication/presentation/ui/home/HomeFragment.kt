package com.example.myapplication.presentation.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.presentation.ui.home.adapter.CustomAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView1.apply{
            layoutManager=LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL ,false)
            //adapter= CustomAdapter(HomeProvider.homemovieList)
            adapter= CustomAdapter()
        }

        /// se pone visible el bottomnavigation
        val view = requireActivity().findViewById<BottomNavigationView>(R.id.nav_view)
        view.visibility = View.VISIBLE
        ///

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}