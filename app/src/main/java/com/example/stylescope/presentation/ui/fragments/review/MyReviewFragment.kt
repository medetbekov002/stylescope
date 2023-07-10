package com.example.stylescope.presentation.ui.fragments.review

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.stylescope.R
import com.example.stylescope.core.BaseFragment
import com.example.stylescope.databinding.FragmentMyReviewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class MyReviewFragment : BaseFragment<FragmentMyReviewBinding, MyReviewViewModel>(R.layout.fragment_my_review) {
    override val binding: FragmentMyReviewBinding by viewBinding(FragmentMyReviewBinding::bind)
    override val viewModel: MyReviewViewModel by viewModel()


}