package com.example.loginactivitytask.adapter

/**
 * 1. This Adapter Class is for ViewPager.
 */

import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.loginactivitytask.fragment.DocumentFragment
import com.example.loginactivitytask.fragment.HomeFragment
import com.example.loginactivitytask.fragment.ProfileFragment

class PagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                HomeFragment()
            }
            1 -> {
                DocumentFragment()
            }
            2 -> {
                ProfileFragment()
            }
            else -> {
                throw Resources.NotFoundException("Position not Valid")
            }
        }
    }
}