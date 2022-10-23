package com.example.loginactivitytask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.loginactivitytask.databinding.ActivityMainBinding
import com.example.loginactivitytask.databinding.ActivityTabLayoutBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class TabLayout : AppCompatActivity() {

    private lateinit var binding : ActivityTabLayoutBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTabLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        switchFragment(HomeFragment())
        binding.bottomnavigationView.setOnItemSelectedListener{
            when(it.itemId){
                R.id.homemenu -> switchFragment(HomeFragment())
                R.id.documentmenu -> switchFragment(DocumentFragment())
                R.id.profilemenu -> switchFragment(ProfileFragment())
                else->{
                    Toast.makeText(this@TabLayout, "No Fragment Selected!!", Toast.LENGTH_SHORT)
                        .show()
                }
            }
            true

        }
    }

    private fun switchFragment(fragment : Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.framelayout,fragment)
        fragmentTransaction.commit()

    }
}