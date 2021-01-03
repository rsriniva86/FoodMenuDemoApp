package com.sam.foodmenudemoapp.viewModel
import androidx.lifecycle.MutableLiveData
import com.airbnb.mvrx.*
import com.sam.foodmenudemoapp.application.FoodApp
import com.sam.foodmenudemoapp.model.MenuItemMainState
import com.sam.foodmenudemoapp.model.MenuItemRepository


class FoodAppMainViewModel (
    initialState: MenuItemMainState,
    private val menuItemRepository: MenuItemRepository
): BaseMvRxViewModel<MenuItemMainState>(initialState,debugMode = true){
    val errorMessage = MutableLiveData<String>()

    init {
        setState {
            copy(menuItems = Loading())
        }
        menuItemRepository.getAllMenuItems()
            .execute {
                copy(menuItems = it)
            }
    }

    companion object : MvRxViewModelFactory<FoodAppMainViewModel, MenuItemMainState> {
        override fun create(viewModelContext: ViewModelContext,
                            state: MenuItemMainState): FoodAppMainViewModel? {
            val menuItemRepository = viewModelContext.app<FoodApp>().menuItemRepository
            return FoodAppMainViewModel(
                state,
                menuItemRepository
            )
        }
    }

}