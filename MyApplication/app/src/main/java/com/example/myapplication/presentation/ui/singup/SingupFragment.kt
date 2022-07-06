package com.example.myapplication.presentation.ui.singup

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentLoginBinding
import com.example.myapplication.databinding.FragmentSingupBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SingupFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SingupFragment : Fragment() {

    private var _binding: FragmentSingupBinding? = null

    private val binding get() = _binding!!

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_singup, container, false)
        _binding = FragmentSingupBinding.inflate(inflater)
        val view = binding.root
        //setup()
        return view

    }


    private fun setup(view: View){

        binding.signupbtn.setOnClickListener{
                var user = binding.emailEditText.text
                var pass = binding.passwordeditText.text


            if(user.isNotEmpty() && pass.isNotEmpty()){
         FirebaseAuth.getInstance().createUserWithEmailAndPassword("${user}",
             "${pass}").addOnCompleteListener{
                        if(it.isSuccessful){
                            val navController : NavController = Navigation.findNavController(view)
                            navController.navigate(R.id.navigation_dashboard)
                        }else{
                            showAlert()
                        }
                    }
            }

        }
    }
         private fun showAlert(){
             var user = binding.emailEditText.text
             var pass = binding.passwordeditText.text

            val builder= AlertDialog.Builder(activity)
            builder.setTitle("error")
            builder.setMessage("It is not posible to create a user with ${user} and ${pass}")
            builder.setPositiveButton("accept",null)
            val dialog: AlertDialog=builder.create()
            dialog.show()
        }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*val navController : NavController = Navigation.findNavController(view)

        val buttonvista: Button = binding.signupbtn

        buttonvista.setOnClickListener{
            navController.navigate(R.id.navigation_dashboard)
        }*/
        setup(view)
        val view = requireActivity().findViewById<BottomNavigationView>(R.id.nav_view)
        view.visibility = View.GONE
    }




    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SingupFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SingupFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}