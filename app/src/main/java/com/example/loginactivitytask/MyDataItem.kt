package com.example.loginactivitytask
/**
 *  1. Data Class for API fetched values.
 */

//Creating Data Class of all the Response Fields
data class MyDataItem(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)