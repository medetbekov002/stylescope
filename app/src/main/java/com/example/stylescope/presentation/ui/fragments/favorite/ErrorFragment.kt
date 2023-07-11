package com.example.stylescope.presentation.ui.fragments.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.stylescope.R
import com.example.stylescope.databinding.FragmentErrorBinding
import com.example.stylescope.databinding.FragmentUserNotFavoriteBinding

class ErrorFragment : Fragment() {
    private lateinit var binding: FragmentErrorBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentErrorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}