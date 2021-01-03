package com.sam.foodmenudemoapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.sam.foodmenudemoapp.databinding.FragmentPizzaBinding
import com.sam.foodmenudemoapp.model.MenuItem
import com.sam.foodmenudemoapp.model.MenuItemCategory

class PizzaFragment:AbstractMenuItemFragment() {

    private lateinit var myViewBinding:FragmentPizzaBinding

    override fun setUIForLoading() {
        myViewBinding.progressBar.visibility = View.VISIBLE
        myViewBinding.pizzaRecyclerView.visibility = View.GONE
    }

    override fun setUIForSuccess() {
        myViewBinding.progressBar.visibility = View.GONE
        myViewBinding.pizzaRecyclerView.visibility = View.VISIBLE
    }

    override fun filterCondition(menuItem: MenuItem): Boolean {
        return menuItem.itemCategory.name.contentEquals(MenuItemCategory.PIZZA.name)
    }

    override fun setAdapter(menuItemAdapter: MenuItemAdapter) {
        myViewBinding.pizzaRecyclerView.adapter = menuItemAdapter
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        myViewBinding = FragmentPizzaBinding.inflate(layoutInflater)
        myViewBinding.pizzaRecyclerView.setLayoutManager(LinearLayoutManager(this.activity))
        initView()
        return myViewBinding.root
    }

}