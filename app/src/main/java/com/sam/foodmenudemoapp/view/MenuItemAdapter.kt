package com.sam.foodmenudemoapp.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sam.foodmenudemoapp.R
import com.sam.foodmenudemoapp.model.MenuItem


class MenuItemAdapter( private val context: Context) :
    RecyclerView.Adapter<MenuItemAdapter.MenuItemHolder?>() {


    private val menuItems = mutableListOf<MenuItem>()

    fun setMenuItems(menuItems: List<MenuItem>) {
        this.menuItems.clear()
        this.menuItems.addAll(menuItems)
        notifyDataSetChanged()
    }

    override fun getItemCount()= menuItems.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuItemHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.menu_item_card, parent, false)
        return MenuItemHolder(view)
    }

    override fun onBindViewHolder(holder: MenuItemHolder, position: Int) {
        val menuItem: MenuItem = menuItems[position]
        holder.setDetails(holder,menuItem)

    }


    inner class MenuItemHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        private val txtName: TextView
        private val txtDescription: TextView
        private val cardImageView:ImageView
        init {
            txtName = itemView.findViewById(R.id.txtName)
            txtDescription = itemView.findViewById(R.id.txtDescription)
            cardImageView=itemView.findViewById(R.id.cardImageView)
        }
        fun setDetails(holder: MenuItemHolder, menuItem: MenuItem) {
            txtName.setText(menuItem.itemName)
            txtDescription.text = menuItem.itemDescription

            Glide
                .with(holder.itemView)
                .load(menuItem?.itemImageLocation)
                .centerCrop()
                .into(holder.cardImageView)

        }

    }



}