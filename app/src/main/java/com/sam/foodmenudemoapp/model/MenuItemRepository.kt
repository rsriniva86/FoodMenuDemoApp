package com.sam.foodmenudemoapp.model

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class MenuItemRepository {
    private val menuItems = mutableListOf<MenuItem>()

    fun getAllMenuItems()= Observable.fromCallable<List<MenuItem>>{
        menuItems.addAll(listOf(
            MenuItem(
                itemName = "Deluxe",
                itemDescription = "deluxe description",
                itemImageLocation = "https://media.istockphoto.com/photos/deluxe-pizza-picture-id138287661",
                itemCategory = MenuItemCategory.PIZZA),
            MenuItem(
                itemName = "Hawaaian",
                itemDescription = "Hawaaian description",
                itemImageLocation = "https://media.istockphoto.com/photos/deluxe-pizza-picture-id138287661",
                itemCategory = MenuItemCategory.PIZZA )
        ))
        menuItems
    }.subscribeOn(Schedulers.io())
}