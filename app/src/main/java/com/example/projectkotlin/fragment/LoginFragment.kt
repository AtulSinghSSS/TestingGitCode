package com.example.projectkotlin.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.projectkotlin.R
import com.example.projectkotlin.activity.MainActivity
import com.example.projectkotlin.databinding.FragmentLoginBinding
import com.example.projectkotlin.utils.SharedPref
import com.example.projectkotlin.viewModel.LoginViewModel

class LoginFragment : Fragment() {

    lateinit var binding: FragmentLoginBinding
    lateinit var loginViewModel: LoginViewModel
    lateinit var activity: MainActivity
    var sharedPref= SharedPref()

    lateinit var strUsername: String
    lateinit var strPassword: String
    lateinit var getContext: Context


    override fun onAttach(context: Context) {
        super.onAttach(context)
        activity = context as MainActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity.hideToolbar()
        binding = FragmentLoginBinding.inflate(inflater, container, false)


        getContext = requireActivity()

        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        binding.btnSignUp.setOnClickListener {
            findNavController().navigate(R.id.action_logInFragment_to_signUpFragment)
        }

        binding.btnLogin.setOnClickListener {
            strUsername = binding.edtUserName.text.toString().trim()

            loginViewModel.getLoginDetails(getContext, strUsername)!!
                .observe(viewLifecycleOwner, Observer {

                    strUsername = binding.edtUserName.text.toString().trim()
                    strPassword = binding.edtPassword.text.toString().trim()
                    if (strUsername.isEmpty()) {
                        Toast.makeText(getContext, "UserId Requried..!!", Toast.LENGTH_SHORT)
                            .show()
                    } else if (strPassword.isEmpty()) {
                        Toast.makeText(getContext, "Password Requried..!!", Toast.LENGTH_SHORT)
                            .show()
                    } else {

                        if (it.status) {
                            if (strUsername.equals(it.username) && strPassword.equals(it.password)) {
                                Toast.makeText(
                                    getContext,
                                    "LogIn Successfully",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()

                                findNavController().navigate(R.id.action_logInFragment_to_homeFragment)
                                activity.showToolbar()


                               sharedPref.init(getContext)
                                sharedPref.putBoolean("LOGIN",true)


                             var login= sharedPref.LOGIN


                            } else {
                                Toast.makeText(
                                    getContext,
                                    "Please Enter Correct Username or Password ",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                            }

                        } else {
                            Toast.makeText(getContext, "Blocked User", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                })
        }



        return binding.root
    }
}