package com.example.myapplication.presentation.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.FragmentProfileBinding
import com.example.myapplication.view.listaperfilcustomadapter
import com.example.myapplication.view.perfilcustomadapter

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val dashboardViewModel =
            ViewModelProvider(this).get(ProfileViewModel::class.java)

        _binding = FragmentProfileBinding.inflate(inflater)
        val view = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.apply{
            layoutManager=LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL ,false)
            adapter= perfilcustomadapter(ProfileFirstProvider.profilefirstList)
        }
//segundo recycler
        binding.recyclerView2.apply{
            layoutManager=LinearLayoutManager(activity,LinearLayoutManager.VERTICAL ,false)
            adapter= listaperfilcustomadapter(ProfileSecondProvider.profilesecondList)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}