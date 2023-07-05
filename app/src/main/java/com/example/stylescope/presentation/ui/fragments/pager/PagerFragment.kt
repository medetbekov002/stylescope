package com.example.stylescope.presentation.ui.fragments.pager

import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.stylescope.R
import com.example.stylescope.core.BaseFragmentWithoutViewModel
import com.example.stylescope.databinding.FragmentPagerBinding
import com.example.stylescope.presentation.ui.adapters.PagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class PagerFragment : BaseFragmentWithoutViewModel<FragmentPagerBinding>(R.layout.fragment_pager) {
    override val binding: FragmentPagerBinding by viewBinding(FragmentPagerBinding::bind)

    override fun initialize() {
        initPagerTabs()
    }

    private fun initPagerTabs() {
        val pageIndex = arguments?.getInt("pageIndex", 0) ?: 0
        binding.pager.adapter = PagerAdapter(this)
        binding.pager.currentItem = pageIndex

        val fragmentsTabs = listOf(
            "Компании",
            "Дизайнеры"
        )

        TabLayoutMediator(binding.pagerTab, binding.pager) { tab, position ->
            tab.text = fragmentsTabs[position]
        }.attach()
    }
}