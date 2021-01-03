package com.sam.foodmenudemoapp.model

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.Uninitialized

data class MenuItemMainState(
    val menuItems:Async<List<MenuItem>> = Uninitialized
) : MvRxState
