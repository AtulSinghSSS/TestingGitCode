package com.example.projectkotlin.fragment

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.projectkotlin.R
import com.example.projectkotlin.activity.MainActivity
import com.example.projectkotlin.databinding.FragmentContactBinding
import com.example.projectkotlin.databinding.FragmentServicesBinding

class ContactFragment : Fragment() {

    lateinit var binding: FragmentContactBinding
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Activity=context as MainActivity
    }

    lateinit var Activity:MainActivity


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentContactBinding.inflate(inflater,container,false)
        Activity.hidemenubar()
        Activity.backPress()





        return binding.root
    }


}