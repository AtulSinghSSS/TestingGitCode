package com.example.projectkotlin.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.projectkotlin.database.LoginDatabase
import com.example.projectkotlin.tableModel.LoginTableModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class LoginRepository(applicationContext: Context) {

    companion object {

        var loginDatabase: LoginDatabase? = null

        var loginTableModel: LiveData<LoginTableModel>? = null

        fun initializeDB(context: Context) : LoginDatabase {
            return LoginDatabase.getDataseClient(context)
        }

        fun insertData(context: Context, username: String, password: String,mobile:String,gender:String,address:String,status: Boolean) {

            loginDatabase = initializeDB(context)

            CoroutineScope(IO).launch {
                val loginDetails = LoginTableModel(username, password,mobile,gender,address,status)
                loginDatabase!!.loginDao().insertData(loginDetails)
            }
        }

        fun getLoginDetails(context: Context, username: String) : LiveData<LoginTableModel>? {

            loginDatabase = initializeDB(context)

            loginTableModel = loginDatabase!!.loginDao().getLoginDetails(username)

            return loginTableModel
        }




    }
}