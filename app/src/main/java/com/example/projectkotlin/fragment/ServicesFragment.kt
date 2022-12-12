package com.example.projectkotlin.fragment

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import com.example.projectkotlin.R
import com.example.projectkotlin.activity.MainActivity
import com.example.projectkotlin.databinding.FragmentServicesBinding


class ServicesFragment : Fragment() {
    lateinit var Activity: MainActivity
    lateinit var binding:FragmentServicesBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Activity =context as MainActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Activity.hidemenubar()
        Activity.backPress()

        binding=FragmentServicesBinding.inflate(inflater,container,false)



        return binding.root
    }

}