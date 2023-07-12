package com.example.stylescope.presentation.ui.fragments.pager

import android.util.Log
import android.view.ViewGroup
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.stylescope.R
import com.example.stylescope.core.BaseFragmentWithoutViewModel
import com.example.stylescope.databinding.FragmentPagerBinding
import com.example.stylescope.presentation.ui.adapters.PagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class PagerFragment : BaseFragmentWithoutViewModel<FragmentPagerBinding>(R.layout.fragment_pager) {
    override val binding: FragmentPagerBinding by viewBinding(FragmentPagerBinding::bind)
    private var selectedTabPosition: Int = 0
    override fun initialize() {
        initPagerTabs()
    }

    private fun initPagerTabs() {
        binding.pager.adapter = PagerAdapter(this)
        val fragmentsTabs = listOf(
            "Компании",
            "Дизайнеры"
        )
        TabLayoutMediator(binding.pagerTab1, binding.pager) { tab, position ->
            tab.text = fragmentsTabs[position]
        }.attach()

        binding.pagerTab1.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                selectedTabPosition = tab.position
                updateTabLayout()
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}

            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

// Вызываем метод для первоначального отображения визуальных изменений в TabLayout
        updateTabLayout()
    }
    private fun updateTabLayout() {
        val tabStrip = binding.pagerTab1.getChildAt(0) as? ViewGroup
        val tabCount = tabStrip?.childCount ?: 0
        for (i in 0 until tabCount) {
            val tabView = tabStrip?.getChildAt(i)
            val layoutParams = tabView?.layoutParams as? ViewGroup.MarginLayoutParams
            if (i == selectedTabPosition) {
                tabView?.setBackgroundResource(R.drawable.bottom_line)
            } else {
                layoutParams?.setMargins(0, 0, 0, 0)
                tabView?.background = null
            }
            tabView?.requestLayout()
        }
    }
}