package com.example.myapplication.presentation.ui.movie.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.FragmentSearchmovieBinding
import com.example.myapplication.view.recyclebuscarcustomadapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [buscarpel.newInstance] factory method to
 * create an instance of this fragment.
 */
class SearchMovieFragment : Fragment() {

    private var _binding: FragmentSearchmovieBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentSearchmovieBinding.inflate(inflater)
        val view = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerViewbuscar.apply{
            layoutManager=LinearLayoutManager(activity,LinearLayoutManager.VERTICAL ,false)
            adapter= recyclebuscarcustomadapter(SearchmovieProvider.searchmovie)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


