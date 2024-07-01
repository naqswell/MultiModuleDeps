package com.example.feature2.api

import android.content.Context
import android.os.Bundle
import android.os.Parcelable
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.core.common.findDependencies
import com.example.core.presentation.viewModelDelegate
import com.example.core.utils.getParcelableValue
import com.example.feature2.R
import com.example.feature2.databinding.FragmentFeature2Binding
import com.example.feature2.internal.common.di.DaggerFeatureArgsConsumerComponent
import com.example.feature2.internal.common.di.FeatureArgsConsumerComponent
import com.example.feature2.internal.presentation.FeatureArgsConsumerViewModel
import com.example.feature2.internal.presentation.mapper.DataDisplayable
import com.example.feature2.internal.presentation.state.UiState
import kotlinx.coroutines.launch
import kotlinx.parcelize.Parcelize


class FeatureArgsConsumerFragment : Fragment(R.layout.fragment_feature_2) {

    private lateinit var injector: FeatureArgsConsumerComponent

    private val viewModel: FeatureArgsConsumerViewModel by viewModelDelegate {
        injector.viewModelFactory.create(requireArguments().getParcelableValue<Args>(ARGS_KEY))
    }

    override fun onAttach(context: Context) {
        injector = DaggerFeatureArgsConsumerComponent.factory().create(findDependencies()).apply {
            inject(this@FeatureArgsConsumerFragment)
        }

        super.onAttach(context)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FragmentFeature2Binding.bind(view).apply {
            observeUiState(this)
        }
    }


    private fun observeUiState(binding: FragmentFeature2Binding) {
        lifecycleScope.launch {
            viewModel.uiStateFlow.collect { uiState ->
                when (uiState) {
                    is UiState.Loading -> {}
                    is UiState.Data -> binding.updateDataUi(uiState.data)
                    is UiState.NoArgs -> {}
                }
            }
        }
    }

    private fun FragmentFeature2Binding.updateDataUi(data: DataDisplayable) {
        txtId.text = data.id.toString()
        txtAdditional.text = data.additional
    }

    companion object {
        private val ARGS_KEY: String = this::class.java.name + "args"

        fun newInstance(id: Int, additional: String): Fragment =
            FeatureArgsConsumerFragment().apply {
                arguments = bundleOf(ARGS_KEY to Args(id = id, additional = additional))
            }
    }

    @Parcelize
    data class Args(
        val id: Int,
        val additional: String,
    ) : Parcelable
}