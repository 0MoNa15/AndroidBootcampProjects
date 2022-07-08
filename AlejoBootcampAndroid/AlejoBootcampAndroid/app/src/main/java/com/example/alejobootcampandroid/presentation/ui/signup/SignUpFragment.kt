package com.example.alejobootcampandroid.presentation.ui.signup

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.alejobootcampandroid.R
import com.example.alejobootcampandroid.databinding.FragmentSignUpBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUp : Fragment() {

    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!
    private val signUpViewModel: SignUpViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View
    {
        // Inflate the layout for this fragment
        _binding = FragmentSignUpBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Set the Action botton event
        binding.btSignupAction.setOnClickListener {
            validateForm(binding.etvSignupName.text.toString(),binding.etvSignupEmail.text.toString(),
                binding.etvSignupPassword.text.toString()
            )
            if(binding.tilSignupName.error == null && binding.tilSignupEmail.error == null &&
                binding.tilSignupPassword.error == null){
                signUpViewModel.signUp(binding.etvSignupName.text.toString(),binding.etvSignupEmail.text.toString(),
                    binding.etvSignupPassword.text.toString())
            }
        }





        //Set arrow back event
        binding.toolbarSignup.setOnMenuItemClickListener{ arrowBack ->
            onOptionsItemSelected(arrowBack).also {
                findNavController().navigate(R.id.action_to_navigation_login)
                //Navigation.createNavigateOnClickListener(R.id.action_to_navigation_login)
            }
        }
    }

    private fun observables(){
        signUpViewModel.status.observe(viewLifecycleOwner){
            if (it){
                Log.i("pokemon","true")
            }else{
                Log.i("pokemon","false")
            }
        }

        signUpViewModel.messages.observe(viewLifecycleOwner){
            val builder = AlertDialog.Builder(context)
                .setTitle(it.get("title"))
                .setMessage(it.get("message"))
                .setPositiveButton(getString(R.string.accept),null)
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }
    }

    private fun validateForm(userName: String, email: String, password: String) {
        with(binding){
            tilSignupName.error = UserDataValidation.isFieldEmpty(userName)
            tilSignupEmail.error = UserDataValidation.isFieldEmpty(email)
            tilSignupPassword.error = UserDataValidation.isFieldEmpty(password)
        }
    }

    private fun showSuccessMessage() {
        val builder = AlertDialog.Builder(context)
            .setTitle(R.string.success)
            .setMessage(R.string.signup_success)
            .setPositiveButton(getString(R.string.accept),null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showErrorMessage() {
        val builder = AlertDialog.Builder(context)
            .setTitle(getString(R.string.error))
            .setMessage(getString(R.string.signup_error))
            .setPositiveButton(getString(R.string.accept),null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    override fun onResume() {
        super.onResume()
        activity?.findViewById<BottomNavigationView>(R.id.nav_view)?.visibility = View.GONE
    }

    override fun onStop() {
        super.onStop()
        activity?.findViewById<BottomNavigationView>(R.id.nav_view)?.visibility = View.VISIBLE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}