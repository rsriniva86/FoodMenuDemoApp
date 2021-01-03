package com.sam.foodmenudemoapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.sam.foodmenudemoapp.databinding.FragmentPizzaBinding
import com.sam.foodmenudemoapp.model.MenuItem

class PizzaFragment:Fragment() {
    private lateinit var pizzaViewBinding: FragmentPizzaBinding

    private var menuItemList:ArrayList<MenuItem> = ArrayList<MenuItem>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val pizzaView:View = inflater!!.inflate(R.layout.fragment_pizza, container, false)
        pizzaViewBinding = FragmentPizzaBinding.inflate(layoutInflater)
        initView()
        return pizzaViewBinding.root
    }

    private fun initView() {
        var recyclerView = pizzaViewBinding.pizzaRecyclerView
        recyclerView.setLayoutManager(LinearLayoutManager(this.activity))
        var adapter = MenuItemAdapter(this.context!!, menuItemList)
        recyclerView.setAdapter(adapter)
        createListData()
    }

    private fun createListData(): List<MenuItem> {
        val deluxe:MenuItem= MenuItem(itemName = "Deluxe",itemDescription = "deluxe description",itemImageLocation = "https://media.istockphoto.com/photos/deluxe-pizza-picture-id138287661")
        val hawaiaan:MenuItem= MenuItem(itemName = "Hawaiaan",itemDescription = "hawaiaan description",itemImageLocation = "tbd")
        val item3:MenuItem=MenuItem(itemName = "tbd",itemDescription = "tbd description",itemImageLocation = "tbd")

        menuItemList.add(deluxe)
        menuItemList.add(hawaiaan)
        return menuItemList
    }


}