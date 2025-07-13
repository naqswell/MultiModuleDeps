package com.example.feature_compound_view.internal.presentation

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import com.example.feature_compound_view.R
import com.example.feature_compound_view.databinding.ConsentsCompoundViewBinding

internal class ConsentsView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) :
    LinearLayout(context, attrs) {

    var onConsentsCheckedChangeListener: (allConsentsChecked: Boolean) -> Unit = {}
    private var binding: ConsentsCompoundViewBinding? = null

    init {
        binding = ConsentsCompoundViewBinding.inflate(LayoutInflater.from(context), this)

        binding?.apply {
            orientation = VERTICAL
            gravity = Gravity.CENTER

            consent1.apply {
                setOnCheckedChangeListener { _, _ -> validateConsents() }
            }

            consent2.apply {
                setOnCheckedChangeListener { _, _ -> validateConsents() }
            }

            context.theme.obtainStyledAttributes(
                attrs, R.styleable.ConsentsView, 0, 0
            ).apply {
                val separatorVisible =
                    getBoolean(R.styleable.ConsentsView_separatorVisibility, true)
                consentsSeparator.visibility = if (separatorVisible) View.VISIBLE else View.GONE
                recycle()
            }
        }
    }

    private fun ConsentsCompoundViewBinding.validateConsents() {
        onConsentsCheckedChangeListener.invoke(consent1.isChecked && consent2.isChecked)
    }
}