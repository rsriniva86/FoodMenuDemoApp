package com.sam.foodmenudemoapp.model

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class MenuItemRepository {
    private val menuItems = mutableListOf<MenuItem>()

    fun getAllMenuItems()= Observable.fromCallable<List<MenuItem>>{
        menuItems.addAll(listOf(
            MenuItem(
                itemName = "Deluxe",
                itemDescription = "A flavourful mix of meat and vegetables, this classic pie will be your go-to for pizza night. ",
                itemImageLocation = "https://media.istockphoto.com/photos/deluxe-pizza-picture-id138287661",
                itemCategory = MenuItemCategory.PIZZA),
            MenuItem(
                itemName = "Hawaiian",
                itemDescription = "Also known as pineapple pizza, is a pizza topped with pineapple, ham, tomato sauce and cheese. The dish tends to spark debate regarding the inclusion of pineapple on a pizza.",
                itemImageLocation = "https://upload.wikimedia.org/wikipedia/commons/thumb/e/ea/Pizza_with_pineapple.jpg/1920px-Pizza_with_pineapple.jpg",
                itemCategory = MenuItemCategory.PIZZA ),
            MenuItem(
                itemName = "Chicago Style",
                itemDescription = "Pizza prepared according to several different styles developed in Chicago. The most famous is the deep-dish pizza.",
                itemImageLocation = "https://upload.wikimedia.org/wikipedia/commons/thumb/b/bd/Chicago-style_pizza.jpg/1920px-Chicago-style_pizza.jpg",
                itemCategory = MenuItemCategory.PIZZA )

        ))
        menuItems
    }.subscribeOn(Schedulers.io())
}