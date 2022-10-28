package com.example.loginactivitytask.activity

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.example.loginactivitytask.R
import com.example.loginactivitytask.adapter.PagerAdapter
import com.example.loginactivitytask.databinding.ActivityTabLayoutBinding
import com.example.loginactivitytask.fragment.HomeFragment

/**
 *  1. This is a Tab layout Activity.
 *  2. This activity has three tabs - Home, Documents, Profile.
 *  3. Home Fragment shows data fetched from API through Retrofit in a RecyclerView Grid Layout.
 *  4. Documents Fragment shows data fetched from API through Retrofit in a RecyclerView Linear Layout.
 *  5. Profile Tab shows the Basic name and Username of User.
 *  6. By default, Home Tab will be Selected.
 *  7. Added ViewPager & Pager Adapter.
 */

class TabLayoutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTabLayoutBinding
    private var previtem: MenuItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTabLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewpager.adapter = PagerAdapter(this)

        //this method Callback is used whenever there is a change in Fragment
        binding.viewpager.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (previtem != null)
                    previtem?.isChecked = false
                else
                    binding.bottomnavigationView.menu[0].isChecked = false
                binding.bottomnavigationView.menu[position].isChecked = true
                previtem = binding.bottomnavigationView.menu[position]
            }
        })
        switchFragment(HomeFragment())
        binding.bottomnavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.homemenu -> {
                    binding.viewpager.currentItem = 0
                }
                R.id.documentmenu -> {
                    binding.viewpager.currentItem = 1
                }
                R.id.profilemenu -> {
                    binding.viewpager.currentItem = 2
                }
                else -> {
                    Toast.makeText(
                        this@TabLayoutActivity, "No Option/Fragment Selected!!", Toast.LENGTH_SHORT
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