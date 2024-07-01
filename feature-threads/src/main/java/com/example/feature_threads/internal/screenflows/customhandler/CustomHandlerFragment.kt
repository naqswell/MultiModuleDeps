package com.example.feature_threads.internal.screenflows.customhandler

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.feature_threads.R
import com.example.feature_threads.databinding.FragmentCustomHandlerBinding

//TODO
class CustomHandlerFragment: Fragment(R.layout.fragment_custom_handler) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FragmentCustomHandlerBinding.bind(view)
    }


    companion object {
        fun newInstance(): Fragment = CustomHandlerFragment().apply {}
    }
}