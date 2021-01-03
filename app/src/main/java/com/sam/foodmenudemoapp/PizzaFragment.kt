package com.sam.foodmenudemoapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.airbnb.mvrx.*
import com.sam.foodmenudemoapp.databinding.FragmentPizzaBinding
import com.sam.foodmenudemoapp.model.MenuItem
import com.sam.foodmenudemoapp.model.MenuItemCategory
import com.sam.foodmenudemoapp.viewModel.FoodAppMainViewModel

class PizzaFragment:BaseMvRxFragment() {

    private lateinit var menuItemAdapter: MenuItemAdapter

    private lateinit var pizzaViewBinding: FragmentPizzaBinding

    private val foodAppMainViewModel: FoodAppMainViewModel by activityViewModel()

    private var menuItemList:ArrayList<MenuItem> = ArrayList<MenuItem>()

    override fun invalidate() {
        withState(foodAppMainViewModel) { state ->
            when (state.menuItems) {
                is Loading -> {
                    pizzaViewBinding.progressBar.visibility = View.VISIBLE
                    pizzaViewBinding.pizzaRecyclerView.visibility = View.GONE
                }
                is Success -> {
                    pizzaViewBinding.progressBar.visibility = View.GONE
                    pizzaViewBinding.pizzaRecyclerView.visibility = View.VISIBLE
                    menuItemAdapter.setMenuItems(state.menuItems.invoke().filter { it.itemCategory.name.contentEquals(MenuItemCategory.PIZZA.name) })
                }
                is Fail -> {
                    Toast.makeText(requireContext(), "Failed to load all the menuItems", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        pizzaViewBinding = FragmentPizzaBinding.inflate(layoutInflater)
        initView()
        return pizzaViewBinding.root
    }





    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {

        pizzaViewBinding.pizzaRecyclerView.setLayoutManager(LinearLayoutManager(this.activity))
        menuItemAdapter = MenuItemAdapter(this.context!!)
        pizzaViewBinding.pizzaRecyclerView.adapter = menuItemAdapter
        foodAppMainViewModel.errorMessage.observe(viewLifecycleOwner, Observer {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        })



    }


}