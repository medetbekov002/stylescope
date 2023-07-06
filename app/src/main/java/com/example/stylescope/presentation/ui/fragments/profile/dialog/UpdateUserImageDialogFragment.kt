package com.example.stylescope.presentation.ui.fragments.profile.dialog

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.provider.MediaStore.Audio.Media
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.stylescope.common.UIState
import com.example.stylescope.databinding.FragmentUpdateUserImageDialogBinding
import com.example.stylescope.presentation.model.user.UpdateUserImageUI
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.lang.Error

class UpdateUserImageDialogFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentUpdateUserImageDialogBinding
    private val viewModel: UpdateUserImageViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUpdateUserImageDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
    }

    private fun launchObserver() {
        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.updateUserImageState.collect {
                    when(it) {
                        is UIState.Idle -> Unit
                        is UIState.Loading -> Toast.makeText(requireContext(), "Loading", Toast.LENGTH_SHORT).show()
                        is UIState.Success -> dismiss()
                        is UIState.Error -> Log.e("ololo", it.error)
                    }
                }
            }
        }
    }

    private fun initListeners() {
        binding.btnClose.setOnClickListener {
            dismiss()
        }

        val galleryLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    val data: Intent? = result.data
                    viewModel.updateUserImage(UpdateUserImageUI(image = data.toString()))
                }
            }


        binding.btnOpenGallery.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            galleryLauncher.launch(intent)
        }
    }
}