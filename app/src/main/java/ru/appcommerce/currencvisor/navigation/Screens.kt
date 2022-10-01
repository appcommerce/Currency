package ru.appcommerce.currencvisor.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.appcommerce.popular_feature.presentation.PopularFragment

object Screens {
    fun mainScreen() = FragmentScreen { PopularFragment.newInstance() }
}
