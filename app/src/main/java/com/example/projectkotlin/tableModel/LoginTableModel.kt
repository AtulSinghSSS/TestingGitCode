package com.example.projectkotlin.tableModel

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Login")
data class LoginTableModel(

    @ColumnInfo(name = "username")
    var username: String,

    @ColumnInfo(name = "password")
    var password: String,

    @ColumnInfo(name = "mobile")
    var mobile: String,

    @ColumnInfo(name = "gender")
    var gender: String,

    @ColumnInfo(name = "address")
    var address: String,

    @ColumnInfo(name = "status")
    var status: Boolean)

{

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0


}