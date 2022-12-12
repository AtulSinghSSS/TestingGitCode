package com.example.projectkotlin.fragment

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.KeyEventDispatcher.dispatchKeyEvent
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.projectkotlin.R
import com.example.projectkotlin.activity.MainActivity
import com.example.projectkotlin.utils.InternetCheck
import com.example.projectkotlin.utils.SharedPref


class SplashScreenFragment : Fragment() {

    lateinit var activity: MainActivity
    var sharedPref=SharedPref()
    override fun onAttach(context: Context) {
        super.onAttach(context)
        activity=context as MainActivity
    }

    var internetCheck = InternetCheck()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        chackInternetConection()
        return inflater.inflate(R.layout.fragment_splash_screen, container, false)
    }

    fun chackInternetConection() {
        if (internetCheck.isNetworkAvailable(requireActivity())) {

            splashScreen()

        } else {
            Toast.makeText(
                requireActivity(),
                "Internet not connect",
                Toast.LENGTH_SHORT
            )
                .show()
        }
    }

    fun splashScreen() {
        Handler().postDelayed({
            var login: Boolean = true

          sharedPref.init(requireActivity())
            if (login) {

                findNavController().navigate(R.id.action_splashScreenFragment_to_homeFragment)


//                getFragmentManager()?.beginTransaction()?.remove(HomeFragment())?.commitAllowingStateLoss()\
//                getFragmentManager()?.beginTransaction()?.replace(R.id.my_nav_host, HomeFragment())?.addToBackStack("my_fragment")?.commit();

                activity.showToolbar()
                Toast.makeText(
                    requireActivity(),
                    "LogIn Successfully",
                    Toast.LENGTH_SHORT
                )
                    .show()


            } else {


                Toast.makeText(
                    requireActivity(),
                    "LogIn Successfully",
                    Toast.LENGTH_SHORT
                )
                    .show()
                findNavController().navigate(R.id.action_splashScreenFragment_to_logInFragment)

            }


        }, 2000)



    }



}