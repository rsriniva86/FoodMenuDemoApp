package com.sam.foodmenudemoapp.model

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class MenuItemRepository {
    private val menuItems = mutableListOf<MenuItem>()

    fun getPizzaMenuItem()= Observable.fromCallable<List<MenuItem>>{
        Thread.sleep(1000)
        menuItems.addAll(listOf(
            MenuItem(
                itemName = "Deluxe",
                itemDescription = "deluxe description",
                itemImageLocation = "https://media.istockphoto.com/photos/deluxe-pizza-picture-id138287661"),
            MenuItem(
                itemName = "Hawaaian",
                itemDescription = "Hawaaian description",
                itemImageLocation = "https://media.istockphoto.com/photos/deluxe-pizza-picture-id138287661")
        ))
        menuItems
    }.subscribeOn(Schedulers.io())
}