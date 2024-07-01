package com.example.feature1.api

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.core.common.findDependencies
import com.example.core.presentation.viewModelDelegate
import com.example.feature1.R
import com.example.feature1.databinding.FragmentFeatureMainBinding
import com.example.feature1.databinding.InputArgsLayoutBinding
import com.example.feature1.internal.common.di.DaggerFeatureMainComponent
import com.example.feature1.internal.common.di.FeatureMainComponent
import com.example.feature1.internal.common.presentation.FeatureMainViewModel

class FeatureMainFragment : Fragment(R.layout.fragment_feature_main) {

    private lateinit var injector: FeatureMainComponent
    private val viewModel: FeatureMainViewModel by viewModelDelegate { injector.viewModel }


    override fun onAttach(context: Context) {
        injector = DaggerFeatureMainComponent.factory().create(findDependencies()).also {
            it.inject(this@FeatureMainFragment)
        }
        viewModel.initCommunicator(injector.featuresCommunicator)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FragmentFeatureMainBinding.bind(view).apply {
            initListItemLayout()
            initFeatureCompoundButton()
        }
    }

    private fun FragmentFeatureMainBinding.initListItemLayout() {
        inputArgsLayout.apply {
            btnConfirm.apply {
                text = getString(R.string.go_feature_args_consumer).uppercase()
                setOnClickListener { launchFeature2() }
            }

            edtTxtId.apply {
                hint = getString(R.string.enter_id)
            }

            edtTxtAdditional.apply {
                hint = getString(R.string.enter_additional_info)
            }
        }
    }

    private fun FragmentFeatureMainBinding.initFeatureCompoundButton() {
        btnFeatureCompoundView.apply {
            text = getString(R.string.go_feature_compound_view).uppercase()
            isAllCaps = true
            setOnClickListener {
                viewModel.onFeatureCompoundView()
            }
        }

        btnFeatureThreads.apply {
            text = getString(R.string.go_feature_threads).uppercase()
            isAllCaps = true
            setOnClickListener {
                viewModel.onFeatureThreads()
            }
        }
    }

    private fun InputArgsLayoutBinding.launchFeature2() {
        val id = edtTxtId.text.toString()
        val additional = edtTxtAdditional.text.toString()
        viewModel.onFeatureArgs(id, additional)
    }

    companion object {
        fun newInstance() = FeatureMainFragment()
    }
}