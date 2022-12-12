package com.example.projectkotlin.fragment

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.projectkotlin.R
import com.example.projectkotlin.activity.MainActivity
import com.example.projectkotlin.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    lateinit var activity: MainActivity
    override fun onAttach(context: Context) {
        super.onAttach(context)
        activity=context as MainActivity
    }


    lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        activity.showToolbar()



        binding= FragmentHomeBinding.inflate(inflater,container,false)



        return binding.root
    }


}