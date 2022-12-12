package com.example.projectkotlin.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.projectkotlin.R
import com.example.projectkotlin.databinding.FragmentSignupBinding
import com.example.projectkotlin.viewModel.LoginViewModel


class SignupFragment : Fragment() {
    lateinit var binding: FragmentSignupBinding
    lateinit var loginViewModel: LoginViewModel
    lateinit var strUsername: String
    lateinit var strPassword: String
    lateinit var strMobile: String
    lateinit var strGender: String
    lateinit var strAddress: String
    var status:Boolean=false
    lateinit var getContext: Context

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSignupBinding.inflate(inflater, container, false)

        getContext = requireActivity()

        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding.btnSave.setOnClickListener {


            binding.apply {
                strUsername = edtUserName.text.toString().trim()
                strPassword = edtPassword.text.toString().trim()
                strMobile = edtMobile.text.toString().trim()

                (binding.radioGrp.checkedRadioButtonId == R.id.radioMale)

                if (binding.radioMale.isChecked) {
                    strGender = "Male"
                } else {
                    strGender = "Female"
                }

                strAddress = edtAddress1.text.toString().trim()
                status = true
            }

            if (strUsername.isEmpty()) {
                Toast.makeText(getContext, "Please enter the username", Toast.LENGTH_SHORT).show()
            } else if (strPassword.isEmpty()) {
                Toast.makeText(getContext, "Please enter the Password", Toast.LENGTH_SHORT).show()
            } else if (strMobile.isEmpty()) {
                Toast.makeText(getContext, "Please enter the Mobile Number", Toast.LENGTH_SHORT).show()
            } else if (strAddress.isEmpty()) {
                Toast.makeText(getContext, "Please enter the Address", Toast.LENGTH_SHORT).show()
            } else {
                loginViewModel.insertData(
                    getContext,
                    strUsername,
                    strPassword,
                    strMobile,
                    strGender,
                    strAddress,
                    status
                )
                Toast.makeText(getContext, "Inserted Successfully", Toast.LENGTH_SHORT).show()
//                binding.lblInsertResponse.text = "Inserted Successfully"
                findNavController().navigate(R.id.action_signUpFragment_to_logInFragment)

            }

        }


        return binding.root
    }
}