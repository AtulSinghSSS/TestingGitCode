package com.example.projectkotlin.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.projectkotlin.R
import com.example.projectkotlin.fragment.LoginFragment
import com.example.projectkotlin.utils.InternetCheck

class SplashScreenActivity : AppCompatActivity() {
    var internetCheck = InternetCheck()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        chackInternetConection()

    }

    fun chackInternetConection() {
        if (internetCheck.isNetworkAvailable(this)) {

            splashScreen()

        } else {
            Toast.makeText(
                applicationContext,
                "Internet not connect",
                Toast.LENGTH_SHORT
            )
                .show()
        }
    }

    fun splashScreen() {
        Handler().postDelayed({

           startActivity(Intent(applicationContext, MainActivity::class.java))
            finish()
        }, 2000)
    }
}