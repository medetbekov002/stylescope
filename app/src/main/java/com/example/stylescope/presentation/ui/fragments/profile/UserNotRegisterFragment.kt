package com.example.stylescope.presentation.ui.fragments.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.stylescope.R
import com.example.stylescope.databinding.FragmentUserNotRegisterBinding

class UserNotRegisterFragment : Fragment() {
    private lateinit var binding: FragmentUserNotRegisterBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserNotRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        constructorListener()
    }

    private fun constructorListener() {
        binding.btnRegisterUser.setOnClickListener {
            findNavController().navigate(R.id.registerFragment)
        }

        binding.btnSignInUser.setOnClickListener {
            findNavController().navigate(R.id.interFragment)
        }
    }


}