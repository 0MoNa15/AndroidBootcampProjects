package com.example.myapplication.presentation.ui.movie.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.FragmentSearchmovieBinding
import com.example.myapplication.presentation.ui.home.HomeViewModel
import com.example.myapplication.presentation.ui.home.adapter.CustomAdapter
import com.example.myapplication.presentation.ui.movie.search.adapter.SearchMovieViewHolder
import com.example.myapplication.presentation.ui.movie.search.searchinterface.APIservice
import com.example.myapplication.presentation.ui.movie.search.viewmodel.SearchMovieViewModel
import com.example.myapplication.view.recyclebuscarcustomadapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.Query
import retrofit2.converter.moshi.MoshiConverterFactory
// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [buscarpel.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class SearchMovieFragment : Fragment() {
//SearchView.OnQueryTextListener
    private lateinit var adapter: recyclebuscarcustomadapter


// private val searchviewmodel: SearchMovieViewModel by viewModels()

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

       // binding.svDogs.setOnQueryTextListener(this)

        val searchViewModel = ViewModelProvider(this).get(SearchMovieViewModel::class.java)


        searchViewModel.getsearchhomemovies()
        searchViewModel.searchhomemovies.observe(viewLifecycleOwner,Observer{
            binding.recyclerViewbuscar.apply{
                layoutManager=LinearLayoutManager(activity,LinearLayoutManager.VERTICAL ,false)
                adapter= recyclebuscarcustomadapter(it)
            }
        })

        //searchviewmodel.getmovie()
        //initRecyclerView()
        return view
    }

    /*fun viewmodelobservable(){

        searchviewmodel.livedatalist.observe(requireActivity()){
            binding.recyclerViewbuscar.apply{
                layoutManager=LinearLayoutManager(activity,LinearLayoutManager.VERTICAL ,false)
                adapter= recyclebuscarcustomadapter(it)
            }
        }
    }*/

  /*  private fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/breed/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
private fun searchByname(query:String){
    CoroutineScope(Dispatchers.IO).launch{
        val call=getRetrofit().create(APIservice::class.java).getmoviesbyname("$query/images")
        val movies =call.body()



activity?.runOnUiThread{
    if(call.isSuccessful){
        val images =movies?.images ?: emptyList()
        dogImages.clear()
        dogImages.addAll(images)
        adapter.notifyDataSetChanged()
    }else{
        showError()
    }
}

    }

}

    private fun showError() {
        Toast.makeText(activity,"fallo",Toast.LENGTH_SHORT).show()
    }*/


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       // viewmodelobservable()


    }

   /*private fun initRecyclerView() {
        adapter = recyclebuscarcustomadapter()
        binding.recyclerViewbuscar.layoutManager= LinearLayoutManager(activity,LinearLayoutManager.VERTICAL ,false)
        binding.recyclerViewbuscar.adapter = adapter
    }*/



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
   /* override fun onQueryTextSubmit(query: String?): Boolean {
        if(!query.isNullOrEmpty()){
            searchByname(query)
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }
}*/

//moshi

/*private val moshi=Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


private fun searchbyname(query: String){
CoroutineScope(Dispatchers.IO).launch {
    val call = getRetrofit().create(APIservice::class.java).getmoviesbyname("$query")
}

}
/*object MarsApi {
val retrofitService: APIservice by lazy {retrofit.create(APIservice::class.java)}
}*/*/

