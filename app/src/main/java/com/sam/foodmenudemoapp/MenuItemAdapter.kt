package com.sam.foodmenudemoapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sam.foodmenudemoapp.model.MenuItem
import java.util.*


class MenuItemAdapter( private val context: Context, menuItems: ArrayList<MenuItem>) :
    RecyclerView.Adapter<MenuItemAdapter.MenuItemHolder?>() {


    private val menuItems: ArrayList<MenuItem>
    init {
        this.menuItems = menuItems
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuItemHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_card, parent, false)
        return MenuItemHolder(view)
    }

    override fun onBindViewHolder(holder: MenuItemAdapter.MenuItemHolder, position: Int) {
        val planet: MenuItem = menuItems[position]
        holder.setDetails(planet)
    }

    override fun getItemCount(): Int {
        return menuItems.size
    }

    inner class MenuItemHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        private val txtName: TextView
        private val txtDescription: TextView
        init {
            txtName = itemView.findViewById(R.id.txtName)
            txtDescription = itemView.findViewById(R.id.txtDescription)
        }
        fun setDetails(menuItem: MenuItem) {
            txtName.setText(menuItem.itemName)
            txtDescription.text = menuItem.itemDescription
        }

    }



}