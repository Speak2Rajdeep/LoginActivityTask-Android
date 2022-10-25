package com.example.loginactivitytask

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

/**
 *  1. This Fragment shows the name and UserName of User after Login.
 *  2. The datas are coming through Shared Preference from Sign-Up Page.
 */

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

@SuppressLint("StaticFieldLeak")
private lateinit var nametv: TextView

@SuppressLint("StaticFieldLeak")
private lateinit var usernametv: TextView

class ProfileFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sharedPreferences: SharedPreferences = this.requireActivity().getSharedPreferences(
            "sharedPref",
            Context.MODE_PRIVATE
        )
        val name = sharedPreferences.getString("name_key", "Default")
        val username = sharedPreferences.getString("username_key", "Default")
        nametv = view.findViewById(R.id.txt_name) as TextView
        usernametv = view.findViewById(R.id.txt_username) as TextView

        usernametv.text = username
        nametv.text = name
    }
}