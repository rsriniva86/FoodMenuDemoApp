package com.sam.foodmenudemoapp.viewModel
import androidx.lifecycle.MutableLiveData
import com.airbnb.mvrx.*
import com.sam.foodmenudemoapp.application.FoodApp
import com.sam.foodmenudemoapp.model.FoodAppMainState
import com.sam.foodmenudemoapp.model.MenuItemRepository


class FoodAppMainViewModel (
    initialState: FoodAppMainState,
    private val menuItemRepository: MenuItemRepository
): BaseMvRxViewModel<FoodAppMainState>(initialState,debugMode = true){
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

    companion object : MvRxViewModelFactory<FoodAppMainViewModel, FoodAppMainState> {
        override fun create(viewModelContext: ViewModelContext,
                            state: FoodAppMainState): FoodAppMainViewModel? {
            val menuItemRepository = viewModelContext.app<FoodApp>().menuItemRepository
            return FoodAppMainViewModel(
                state,
                menuItemRepository
            )
        }
    }

}