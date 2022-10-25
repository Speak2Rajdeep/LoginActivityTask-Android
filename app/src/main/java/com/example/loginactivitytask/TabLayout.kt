package com.example.loginactivitytask

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.loginactivitytask.databinding.ActivityTabLayoutBinding

/**
 *  1. This is a Tab layout Activity.
 *  2. This activity has three tabs - Home, Documents, Profile.
 *  3. Home Fragment shows data fetched from API through Retrofit in a RecyclerView Grid Layout.
 *  4. Documents Fragment shows data fetched from API through Retrofit in a RecyclerView Linear Layout.
 *  5. Profile Tab shows the Basic name and Username of User.
 *  6. By default, Home Tab will be Selected.
 */

class TabLayout : AppCompatActivity() {

    private lateinit var binding: ActivityTabLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTabLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        switchFragment(HomeFragment())
        binding.bottomnavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.homemenu -> switchFragment(HomeFragment())
                R.id.documentmenu -> switchFragment(DocumentFragment())
                R.id.profilemenu -> switchFragment(ProfileFragment())
                else -> {
                    Toast.makeText(
                        this@TabLayout,
                        "No Option/Fragment Selected!!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            true
        }
    }

    private fun switchFragment(fragment: Fragment) {

        //Here we Replace Activity to Fragment
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.framelayout, fragment)
        fragmentTransaction.commit()
    }
}