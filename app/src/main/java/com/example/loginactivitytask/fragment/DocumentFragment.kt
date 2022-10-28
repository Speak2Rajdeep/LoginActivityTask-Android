package com.example.loginactivitytask.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.loginactivitytask.Interface.ApiInterface
import com.example.loginactivitytask.R
import com.example.loginactivitytask.adapter.MyAdapter
import com.example.loginactivitytask.dataClass.MyDataItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val baseURL = "https://jsonplaceholder.typicode.com/"

/**
 *  1. This Fragment shows Recycler View with Linear Layout.
 */

class DocumentFragment : Fragment() {

    private lateinit var myAdapter: MyAdapter
    private lateinit var recyclerView: RecyclerView
    private var responseBody: ArrayList<MyDataItem> = ArrayList()
    lateinit var progressBar: ProgressBar
    lateinit var loading: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_document, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //This Method is used here to put the data from the getMyData() Method to the RecyclerView
        recyclerView = view.findViewById(R.id.recycler)
        progressBar = view.findViewById(R.id.progress)
        loading = view.findViewById(R.id.loading)

        recyclerView.apply {
            val layoutManager = LinearLayoutManager(activity)
            this.layoutManager = layoutManager
            this.setHasFixedSize(true)
            myAdapter = MyAdapter(context, responseBody)
            this.adapter = myAdapter
            getMyData()
        }
    }

    //This method fetches all the Data from the API through Retrofit Library
    private fun getMyData() {
        //Creating Retrofit Object
        val retrofitBuilder =
            Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(baseURL)
                .build().create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getData()

        //Calling Retrofit : Enqueue method for queueing the Response
        retrofitData.enqueue(object : Callback<List<MyDataItem>> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(
                call: Call<List<MyDataItem>>, response: Response<List<MyDataItem>>
            ) {
                //Adding Responses to the Response Body and Setting the Visibility of the Progressbar
                response.body()!!.let { responseBody.addAll(it) }
                myAdapter.notifyDataSetChanged()
                progressBar.visibility = View.GONE
                loading.visibility = View.GONE
            }

            override fun onFailure(call: Call<List<MyDataItem>>, t: Throwable) {
                //On Failure Make Toast with Messages
                Toast.makeText(activity, "OnFailure Called!", Toast.LENGTH_SHORT).show();
            }
        })
    }
}