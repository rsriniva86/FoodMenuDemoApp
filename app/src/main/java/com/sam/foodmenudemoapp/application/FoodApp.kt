package com.sam.foodmenudemoapp.application

import android.app.Application
import com.sam.foodmenudemoapp.model.MenuItemRepository

class FoodApp :Application() {
    val menuItemRepository by lazy {
        MenuItemRepository()
    }
}