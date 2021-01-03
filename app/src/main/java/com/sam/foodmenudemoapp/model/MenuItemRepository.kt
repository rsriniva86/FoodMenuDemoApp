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
                itemCategory = MenuItemCategory.PIZZA ),
            MenuItem(
                itemName = "Nigiri",
                itemDescription = "Consists of thinly sliced, raw fish pressed on top of sushi rice",
                itemImageLocation = "https://food.fnr.sndimg.com/content/dam/images/food/fullset/2003/10/27/0/ad1a10_sushi.jpg.rend.hgtvcom.826.620.suffix/1371583036385.jpeg",
                itemCategory = MenuItemCategory.SUSHI ),
            MenuItem(
                itemName = "Sashimi",
                itemDescription = "Sashimi consists of thin slices of raw fish either salmon or tuna.",
                itemImageLocation = "https://upload.wikimedia.org/wikipedia/commons/thumb/8/83/Sashimi_combo_%2830122297838%29.jpg/1920px-Sashimi_combo_%2830122297838%29.jpg",
                itemCategory = MenuItemCategory.SUSHI ),
            MenuItem(
                itemName = "Lime Juice",
                itemDescription = "The lime rickey is a refreshingly tart combination of fresh lime juice, simple syrup, and seltzer. ",
                itemImageLocation = "https://www.thespruceeats.com/thmb/2hjFZTZ9xr7TlLaQ22hY3t-9rc0=/960x0/filters:no_upscale():max_bytes(150000):strip_icc()/lime-rickey-908792-hero-5c25321646e0fb0001ebbbdf.jpg",
                itemCategory = MenuItemCategory.DRINKS ),
            MenuItem(
                itemName = "Banana Milkshake",
                itemDescription = "Fruit milkshakes or smoothies are very popular",
                itemImageLocation = "https://149366112.v2.pressablecdn.com/wp-content/uploads/2019/03/vegan-golden-banana-milkshake-1-949x800.jpg",
                itemCategory = MenuItemCategory.DRINKS )

        ))
        menuItems
    }.subscribeOn(Schedulers.io())
}