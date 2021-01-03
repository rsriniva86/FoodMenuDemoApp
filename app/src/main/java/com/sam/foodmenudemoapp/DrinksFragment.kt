package com.sam.foodmenudemoapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.sam.foodmenudemoapp.databinding.FragmentDrinksBinding
import com.sam.foodmenudemoapp.databinding.FragmentSushiBinding
import com.sam.foodmenudemoapp.model.MenuItem
import com.sam.foodmenudemoapp.model.MenuItemCategory

class DrinksFragment:AbstractMenuItemFragment() {
    private lateinit var myViewBinding: FragmentDrinksBinding

    override fun setUIForLoading() {
        myViewBinding.progressBar.visibility = View.VISIBLE
        myViewBinding.drinksRecyclerView.visibility = View.GONE
    }

    override fun setUIForSuccess() {
        myViewBinding.progressBar.visibility = View.GONE
        myViewBinding.drinksRecyclerView.visibility = View.VISIBLE
    }
    override fun setAdapter(menuItemAdapter: MenuItemAdapter) {
        myViewBinding.drinksRecyclerView.adapter = menuItemAdapter
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        myViewBinding = FragmentDrinksBinding.inflate(layoutInflater)
        myViewBinding.drinksRecyclerView.setLayoutManager(LinearLayoutManager(this.activity))
        initView()
        return myViewBinding.root
    }
    override fun filterCondition(menuItem: MenuItem): Boolean {
        return menuItem.itemCategory.name.contentEquals(MenuItemCategory.DRINKS.name)
    }

}