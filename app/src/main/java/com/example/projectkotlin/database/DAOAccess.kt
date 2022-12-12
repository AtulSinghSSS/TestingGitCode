package com.example.projectkotlin.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.projectkotlin.tableModel.LoginTableModel

@Dao
interface DAOAccess {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(loginTableModel: LoginTableModel) : Long?

    @Query("SELECT * FROM Login WHERE username =:username")
    fun getLoginDetails(username: String?) : LiveData<LoginTableModel>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(loginTableModel: LoginTableModel)


    @Delete
    fun detete(loginTableModel: LoginTableModel)

}