package ru.appcommerce.currencvisor.presentation

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.google.android.material.navigation.NavigationBarView
import ru.appcommerce.core_ui.di.holders.CoreComponentHolder
import ru.appcommerce.currencvisor.CurrencyApp
import ru.appcommerce.currencvisor.R
import ru.appcommerce.currencvisor.databinding.ActivityMainBinding
import ru.appcommerce.currencvisor.di.components.DaggerMainComponent
import ru.appcommerce.currencvisor.di.components.MainComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    private val mainComponent: MainComponent by lazy {
        DaggerMainComponent
            .builder()
            .navComponent(CurrencyApp.navComponent)
            .coreComponent(CoreComponentHolder.inject())
            .build()
    }

    private val mainViewModel: MainViewModel by viewModels()
    private val binding: ActivityMainBinding by viewBinding(ActivityMainBinding::bind)
    private val navigator: AppNavigator = AppNavigator(this, R.id.main_container)

    override fun onCreate(savedInstanceState: Bundle?) {
        mainComponent.inject(this)
        mainComponent.inject(mainViewModel)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding.downMenu.setOnItemSelectedListener(this)
        if (savedInstanceState == null) {
            mainViewModel.startFragment()
        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.popular_menu -> {
                mainViewModel.navigateToPopular()
                true
            }
            R.id.favorite_menu -> {
                mainViewModel.navigateToFavorite()
                true
            }
            else -> false
        }
    }

}
