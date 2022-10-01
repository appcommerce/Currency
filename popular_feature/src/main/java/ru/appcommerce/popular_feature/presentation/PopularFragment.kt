package ru.appcommerce.popular_feature.presentation

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.appcommerce.core_ui.base.BaseFragment
import ru.appcommerce.core_ui.base.UiState
import ru.appcommerce.core_ui.di.components.CoreComponent
import ru.appcommerce.network.di.NetworkComponent
import ru.appcommerce.popular_feature.R
import ru.appcommerce.popular_feature.databinding.FragmentPopularBinding
import ru.appcommerce.popular_feature.di.DaggerPopularFeatureComponent

class PopularFragment: BaseFragment<PopularViewModel, FragmentPopularBinding>(
    R.layout.fragment_popular
) {

    override val binding: FragmentPopularBinding by viewBinding()
    override val viewModel: PopularViewModel by viewModels()

    override fun initView() {

    }

    override fun initListeners() {
        viewModel._currencies.observe(viewLifecycleOwner) {
            when(it) {
                is UiState.Loading -> {
                    binding.tvPopular.text = "Loading"
                }
                is UiState.EmptyData -> {
                    binding.tvPopular.text = "Empty"
                }
                is UiState.Error -> {
                    binding.tvPopular.text = it.error.localizedMessage
                }
                is UiState.Data -> {
                    binding.tvPopular.text = it.data.firstOrNull()?.change.toString()
                }
            }
        }
    }

    override fun fragmentStarted() = Unit

    override fun initFeatureComponent(
        networkComponent: NetworkComponent,
        coreComponent: CoreComponent
    ) {
        DaggerPopularFeatureComponent
            .builder()
            .networkComponent(networkComponent)
            .coreComponent(coreComponent)
            .build()
            .inject(viewModel)

    }

    companion object {
        fun newInstance() = newInstance<PopularFragment>()
    }
}
