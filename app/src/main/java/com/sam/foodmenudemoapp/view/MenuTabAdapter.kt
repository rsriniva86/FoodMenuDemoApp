package com.sam.foodmenudemoapp.view

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class MenuTabAdapter(activity: AppCompatActivity, private val itemsCount: Int) :  FragmentStateAdapter(activity) {

    override fun getItemCount(): Int {
        return itemsCount
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> {
                return PizzaFragment()
            }
            1 -> {
                return SushiFragment()
            }
            2 -> {
                return DrinksFragment()
            }
            else -> return PizzaFragment()
        }
    }
}