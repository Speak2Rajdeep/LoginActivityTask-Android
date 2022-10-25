package com.example.loginactivitytask

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapterHome(val context: Context, val userList: List<MyDataItem>) :
    RecyclerView.Adapter<MyAdapterHome.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //Creating Variables and Initializing them via init block
        var id: TextView
        var title: TextView

        init {
            id = itemView.findViewById(R.id.id_tv)
            title = itemView.findViewById(R.id.title_tv)
        }
    }

    @SuppressLint("RestrictedApi")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //Passing the XML and Converting it to view

        var itemView = LayoutInflater.from(context).inflate(R.layout.single_row_home, parent, false)
        //Calling the Holder class and passing the itemview
        return ViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        //Binding the data into the View
        holder.id.text = userList[position].id.toString()
        holder.title.text = userList[position].title.toString()
    }

    override fun getItemCount(): Int {

        //Returning the Size of the List
        return userList.size
    }
}