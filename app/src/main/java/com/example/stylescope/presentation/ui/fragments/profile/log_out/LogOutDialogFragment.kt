package com.example.stylescope.presentation.ui.fragments.profile.log_out

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.stylescope.R
import com.example.stylescope.data.local.Pref
import com.example.stylescope.databinding.FragmentLogOutDialogBinding

class LogOutDialogFragment(private val check: (checkText: String) -> Unit) : DialogFragment() {
    private lateinit var binding: FragmentLogOutDialogBinding
    private val pref: Pref by lazy { Pref(requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dialog?.window?.setBackgroundDrawableResource(R.drawable.circle_corner_bg)
        binding = FragmentLogOutDialogBinding.inflate(inflater, container, false)
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

        binding.btnNoLogOut.setOnClickListener {
            dismiss()
        }

        binding.btnLogOut.setOnClickListener {
            pref.deleteToken()
            check("log out")
            dismiss()
        }
    }
}