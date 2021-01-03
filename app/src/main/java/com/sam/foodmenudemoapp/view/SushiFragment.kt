package com.sam.foodmenudemoapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.sam.foodmenudemoapp.databinding.FragmentSushiBinding
import com.sam.foodmenudemoapp.model.MenuItem
import com.sam.foodmenudemoapp.model.MenuItemCategory

class SushiFragment: AbstractMenuItemFragment() {
    private lateinit var myViewBinding: FragmentSushiBinding

    override fun setUIForLoading() {
        myViewBinding.progressBar.visibility = View.VISIBLE
        myViewBinding.sushiRecyclerView.visibility = View.GONE
    }

    override fun setUIForSuccess() {
        myViewBinding.progressBar.visibility = View.GONE
        myViewBinding.sushiRecyclerView.visibility = View.VISIBLE
    }
    override fun setAdapter(menuItemAdapter: MenuItemAdapter) {
        myViewBinding.sushiRecyclerView.adapter = menuItemAdapter
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        myViewBinding = FragmentSushiBinding.inflate(layoutInflater)
        myViewBinding.sushiRecyclerView.setLayoutManager(LinearLayoutManager(this.activity))
        initView()
        return myViewBinding.root
    }
    override fun filterCondition(menuItem: MenuItem): Boolean {
        return menuItem.itemCategory.name.contentEquals(MenuItemCategory.SUSHI.name)
    }

}