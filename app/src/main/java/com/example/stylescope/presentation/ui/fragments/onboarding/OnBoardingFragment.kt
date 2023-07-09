package com.example.stylescope.presentation.ui.fragments.onboarding

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.stylescope.R
import com.example.stylescope.core.BaseFragment
import com.example.stylescope.data.local.Pref
import com.example.stylescope.databinding.FragmentOnBoardingBinding
import me.relex.circleindicator.CircleIndicator3
import org.koin.androidx.viewmodel.ext.android.viewModel


class OnBoardingFragment :BaseFragment<FragmentOnBoardingBinding,OnBoardingViewModel>(R.layout.fragment_on_boarding) {

    override val binding: FragmentOnBoardingBinding by viewBinding(FragmentOnBoardingBinding::bind)
    override val viewModel: OnBoardingViewModel by viewModel()
    private val pref:Pref by lazy { Pref(requireContext()) }
    private val adapter:OnBoardingAdapter by lazy { OnBoardingAdapter() }


    override fun initialize() {
        super.initialize()
        initAdapter()
    }

    private fun initAdapter() {
        try {
            Log.e("ololo","OBF.iA.try.1")
            binding.pager.adapter = adapter
            val indicator = view?.findViewById<CircleIndicator3>(R.id.circle_indicator)
            indicator?.setViewPager(binding.pager)
            Log.e("ololo","OBF.iA.try.2")
        }catch (e:Exception){
            Log.e("ololo","OBF.iA.catch:$e")
        }

    }

}