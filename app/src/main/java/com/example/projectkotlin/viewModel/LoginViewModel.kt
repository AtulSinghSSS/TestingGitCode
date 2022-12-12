package com.example.projectkotlin.viewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.projectkotlin.tableModel.LoginTableModel
import com.example.projectkotlin.repository.LoginRepository

class LoginViewModel: ViewModel() {

    var liveDataLogin: LiveData<LoginTableModel>? = null

    fun insertData(context: Context, username: String, password: String,mobile:String,gender:String,address:String, status:Boolean) {
        LoginRepository.insertData(context,username,password,mobile,gender,address,status)
    }

    fun getLoginDetails(context: Context, username: String) : LiveData<LoginTableModel>? {
        liveDataLogin = LoginRepository.getLoginDetails(context, username)
        return liveDataLogin
    }
}