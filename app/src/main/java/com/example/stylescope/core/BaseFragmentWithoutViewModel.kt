package com.example.stylescope.core

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragmentWithoutViewModel<Binding : ViewBinding>
    (@LayoutRes layoutId: Int) : Fragment(layoutId) {

    protected abstract val binding: Binding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        constructListeners()
        launchObservers()
    }

    protected open fun initialize() {}

    protected open fun constructListeners() {}

    protected open fun launchObservers() {}
}