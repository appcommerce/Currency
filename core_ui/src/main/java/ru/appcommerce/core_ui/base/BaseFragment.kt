package ru.appcommerce.core_ui.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import ru.appcommerce.core_ui.di.components.CoreComponent
import ru.appcommerce.core_ui.di.holders.CoreComponentHolder
import ru.appcommerce.network.di.DataSourceHolder
import ru.appcommerce.network.di.NetworkComponent

abstract class BaseFragment<VM: BaseViewModel, Binding: ViewBinding>(
    layoutId: Int
): Fragment(layoutId) {

    protected abstract val binding: Binding
    protected abstract val viewModel: VM
    val coreComponent: CoreComponent by lazy { CoreComponentHolder.inject() }
    val dataSourceComponent by lazy { DataSourceHolder.inject(requireActivity().applicationContext) }

    override fun onCreate(savedInstanceState: Bundle?) {
        initFeatureComponent(dataSourceComponent, coreComponent)
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        viewModel.start()
        fragmentStarted()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initListeners()
    }

    abstract fun initView()
    abstract fun initListeners()
    abstract fun fragmentStarted()
    abstract fun initFeatureComponent(
        networkComponent: NetworkComponent,
        coreComponent: CoreComponent
    )

    companion object {
        inline fun <reified F: Fragment> newInstance(
            input: Bundle = Bundle(0)
        ): F = F::class.java.newInstance().apply {
            arguments = input
        }
    }
}
