package com.example.feature_compound_view.api

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.core.common.findDependencies
import com.example.feature_compound_view.R
import com.example.feature_compound_view.databinding.FragmentFeatureCompoundViewBinding
import com.example.feature_compound_view.internal.common.di.DaggerFeatureCompoundViewComponent
import com.example.feature_compound_view.internal.common.di.FeatureCompoundViewComponent

class FeatureCompoundViewFragment : Fragment(R.layout.fragment_feature_compound_view) {

    private lateinit var injector: FeatureCompoundViewComponent

    override fun onAttach(context: Context) {
        super.onAttach(context)
        injector = DaggerFeatureCompoundViewComponent
            .factory()
            .create(findDependencies()).also { it.inject(this@FeatureCompoundViewFragment) }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FragmentFeatureCompoundViewBinding.bind(view).apply {
            initConsentsView()
        }
    }


    private fun FragmentFeatureCompoundViewBinding.initConsentsView() {
        consentsView.onConsentsCheckedChangeListener = { allConsentsChecked ->
            confirmButton.isEnabled = allConsentsChecked
        }
    }

    companion object {
        fun newInstance(): Fragment = FeatureCompoundViewFragment().apply {}
    }
}