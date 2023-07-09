package com.example.stylescope.presentation.ui.fragments.profile.dialog

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
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
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.io.File
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
        launchObserver()
    }

    private fun launchObserver() {
        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.updateUserImageState.collect {
                    when(it) {
                        is UIState.Idle -> Unit
                        is UIState.Loading -> Unit
                        is UIState.Success -> dismiss()
                        is UIState.Error -> Log.e("ololo", it.error)
                    }
                }
            }
        }
    }

    @SuppressLint("Recycle")
    private fun initListeners() {
        binding.btnClose.setOnClickListener {
            dismiss()
        }

        val galleryLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    val selectedImage = result.data?.data
                    val imageFile = File(getRealPathFromURI(selectedImage!!))
                    val imagePart = createImagePart(imageFile.toString())
                    viewModel.updateUserImage(imagePart)
                }
            }


        binding.btnOpenGallery.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            galleryLauncher.launch(intent)
        }
    }

    private fun createImagePart(filePath: String): MultipartBody.Part {
        val file = File(filePath)
        val requestFile = RequestBody.create("image/*".toMediaTypeOrNull(), file)
        return MultipartBody.Part.createFormData("image", file.name, requestFile)
    }

    private fun getRealPathFromURI(uri: Uri): String {
        val filePathColumn = arrayOf(MediaStore.Images.Media.DATA)
        val cursor = requireActivity().contentResolver.query(uri, filePathColumn, null, null, null)
        cursor?.moveToFirst()
        val columnIndex = cursor?.getColumnIndex(filePathColumn[0])
        val filePath = columnIndex?.let { cursor.getString(it) }
        cursor?.close()
        return filePath!!
    }
}