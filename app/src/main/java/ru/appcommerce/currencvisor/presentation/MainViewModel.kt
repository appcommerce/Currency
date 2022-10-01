package ru.appcommerce.currencvisor.presentation

import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.Router
import ru.appcommerce.currencvisor.navigation.Screens
import javax.inject.Inject

class MainViewModel: ViewModel() {

    @Inject
    lateinit var router: Router

    fun startFragment() {
        router.newRootScreen(Screens.mainScreen())
    }

    fun navigateToFavorite() {

    }

    fun navigateToPopular() {
        router.replaceScreen(Screens.mainScreen())
    }
}
