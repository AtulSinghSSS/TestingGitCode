package com.example.projectkotlin.activity


import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.projectkotlin.R
import com.example.projectkotlin.databinding.ActivityMainBinding
import com.example.projectkotlin.utils.SharedPref

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        hideToolbar()

        binding.homeToolbar.menuDrawable.setOnClickListener({
            binding.myDrawerLayout.openDrawer(GravityCompat.START)
        })


        binding.navigationMenu.setNavigationItemSelectedListener {
            when (it.itemId) {

                R.id.nav_home -> {

                    findNavController(R.id.my_nav_host).navigate(R.id.homeFragment)
                    binding.myDrawerLayout.closeDrawer(GravityCompat.START)
//                           setSupportActionBar(binding.homeToolbar.toolbar);

                }
                R.id.nav_services -> {

                    findNavController(R.id.my_nav_host).navigate(R.id.servicesFragment)
                    binding.myDrawerLayout.closeDrawer(GravityCompat.START)
//                           setSupportActionBar(binding.homeToolbar.toolbar);

                }
                R.id.nav_contact -> {

                    findNavController(R.id.my_nav_host).navigate(R.id.contactFragment)
                    binding.myDrawerLayout.closeDrawer(GravityCompat.START)

                }

                R.id.nav_logout -> {

                    findNavController(R.id.my_nav_host).navigate(R.id.logInFragment)
                    binding.myDrawerLayout.closeDrawer(GravityCompat.START)

                }
            }
            true
        }




    }


    fun showToolbar() {
        binding.homeToolbar.appBar.visibility = View.VISIBLE

    }

    fun hideToolbar() {

        binding.homeToolbar.appBar.visibility = View.GONE

    }

    fun hidemenubar() {
        binding.homeToolbar.menuDrawable.visibility=View.GONE
    }
    fun showmenubar() {
        binding.homeToolbar.menuDrawable.visibility=View.VISIBLE
    }

    fun backPress() {
        binding.homeToolbar.menuback.visibility=View.VISIBLE
        binding.homeToolbar.menuback.setOnClickListener({
            onBackPressed()
            showmenubar()
            binding.homeToolbar.menuback.visibility=View.GONE
        })

    }

}




