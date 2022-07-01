package com.example.myapplication.presentation.ui.login


import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.Navigation

import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null

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
        _binding = FragmentLoginBinding.inflate(inflater)
        val view = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

         val navController : NavController = Navigation.findNavController(view)

         val buttonvista: Button = binding.button

        buttonvista.setOnClickListener{

            var user = binding.TextPersonName.text
            var pass = binding.TextPassword.text


            if(user.isNotEmpty() && pass.isNotEmpty()){
                FirebaseAuth.getInstance().signInWithEmailAndPassword("${user}",
                    "${pass}").addOnCompleteListener{
                    if(it.isSuccessful){
                        navController.navigate(R.id.navigation_home)
                    }else{
                        showAlert()
                    }
                }

            }


        }


        val registro: TextView =binding.textRegistrate

        registro.setOnClickListener{
            navController.navigate(R.id.action_loginFragment_to_singupFragment)
        }

    }


    private fun showAlert(){
        var user = binding.TextPersonName.text
        var pass = binding.TextPassword.text

        val builder= AlertDialog.Builder(activity)
        builder.setTitle("error")
        builder.setMessage("It is not posible to sign in with user ${user} and ${pass}")
        builder.setPositiveButton("accept",null)
        val dialog: AlertDialog =builder.create()
        dialog.show()
    }




    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }




    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LoginFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LoginFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}