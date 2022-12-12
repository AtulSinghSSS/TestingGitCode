package com.example.projectkotlin.RetrofitApiData

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil.setContentView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.projectkotlin.R

class DemoActivity : AppCompatActivity() {

    lateinit var context: Context
    lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo)

        context = this@DemoActivity

        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        val btnClick: Button = findViewById(R.id.btnClick) as Button
        var lblResponse:TextView=findViewById(R.id.lblResponse)as TextView
        btnClick.setOnClickListener {

//            wp7progressBar.showProgressBar()

            mainActivityViewModel.getUser()!!.observe(this, Observer { serviceSetterGetter ->

//                wp7progressBar.hideProgressBar()

                val msg = serviceSetterGetter.message

                lblResponse.text = msg

            })

        }
    }
}