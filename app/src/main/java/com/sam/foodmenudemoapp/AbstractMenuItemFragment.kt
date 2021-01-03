package com.sam.foodmenudemoapp

import android.widget.Toast
import androidx.lifecycle.Observer
import com.airbnb.mvrx.*
import com.sam.foodmenudemoapp.model.MenuItem
import com.sam.foodmenudemoapp.model.MenuItemCategory
import com.sam.foodmenudemoapp.viewModel.FoodAppMainViewModel

abstract class AbstractMenuItemFragment :BaseMvRxFragment() {
    private lateinit var menuItemAdapter: MenuItemAdapter

    private val foodAppMainViewModel: FoodAppMainViewModel by activityViewModel()
    override fun invalidate() {
        withState(foodAppMainViewModel) { state ->
            when (state.menuItems) {
                is Loading -> {
                    setUIForLoading()
                }
                is Success -> {
                    setUIForSuccess()
                    menuItemAdapter.setMenuItems(state.menuItems.invoke().filter {
                        filterCondition(it)
                    })

                }
                is Fail -> {
                    Toast.makeText(requireContext(), "Failed to load all the menuItems", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    abstract fun setUIForLoading()
    abstract fun setUIForSuccess()
    abstract fun filterCondition(menuItem:MenuItem): Boolean
    abstract fun setAdapter(menuItemAdapter: MenuItemAdapter)

    open protected fun initView(){
        menuItemAdapter = MenuItemAdapter(this.context!!)
        foodAppMainViewModel.errorMessage.observe(viewLifecycleOwner, Observer {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        })
        setAdapter(menuItemAdapter)
    }
}