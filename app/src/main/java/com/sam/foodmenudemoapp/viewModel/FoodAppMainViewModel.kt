import androidx.lifecycle.MutableLiveData
import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.MavericksViewModelFactory
import com.sam.foodmenudemoapp.application.FoodApp
import com.sam.foodmenudemoapp.model.FoodAppMainState
import com.sam.foodmenudemoapp.model.MenuItem


class FoodAppMainViewModel (initialState: FoodAppMainState, private val menuItem: MenuItem ): BaseMvRxViewModel<FoodAppMainState>(initialState){
    init {
        setState {
            copy(movies = Loading())
        }
        watchlistRepository.getWatchlistedMovies()
            .execute {
                copy(movies = it)
            }
    }
    companion object : MavericksViewModelFactory<FoodAppMainViewModel, FoodAppMainState> {

        val errorMessage = MutableLiveData<String>()



        override fun create(viewModelContext: ViewModelContext,
                            state: FoodAppMainState): FoodAppMainViewModel? {
            val menuItem1 =
                viewModelContext.app<FoodApp>()
            return FoodAppMainViewModel(state, menuItem=menuItem1)
        }
    }

}