package com.example.stylescope.presentation.ui.fragments.pager.log_out

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.example.stylescope.R
import com.example.stylescope.databinding.FragmentNotRegisterDialogBinding

class NotRegisterDialogFragment() : DialogFragment() {
    private lateinit var binding: FragmentNotRegisterDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dialog?.window?.setBackgroundDrawableResource(R.drawable.circle_corner_bg)
        binding = FragmentNotRegisterDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        constructorListeners()
    }

    private fun constructorListeners() {
        binding.btnCloseLogOut.setOnClickListener {
            dismiss()
        }

        binding.btnSignIn.setOnClickListener {
            findNavController().navigate(R.id.interFragment)
            dismiss()
        }

        binding.btnSignUp.setOnClickListener {
           findNavController().navigate(R.id.registerFragment)
            dismiss()
        }
    }
}