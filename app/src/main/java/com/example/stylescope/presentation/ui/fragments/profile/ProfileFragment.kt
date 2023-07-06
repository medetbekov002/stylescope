package com.example.stylescope.presentation.ui.fragments.profile

import android.util.Log
import android.widget.Toast
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.stylescope.R
import com.example.stylescope.core.BaseFragment
import com.example.stylescope.databinding.FragmentProfileBinding
import com.example.stylescope.presentation.model.user.UpdateUserProfileUI
import com.example.stylescope.presentation.utils.loadImage
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileFragment : BaseFragment<FragmentProfileBinding, ProfileViewModel>(R.layout.fragment_profile) {
    override val binding: FragmentProfileBinding by viewBinding(FragmentProfileBinding::bind)
    override val viewModel: ProfileViewModel by viewModel()

    override fun launchObservers() {

        viewModel.userProfileState.spectateUiState(success = {
            val fullName = "${it.firstName} ${it.lastName}"
            it.image?.let { it1 -> binding.imgUserProfile.loadImage(it1) }
            binding.tvUserProfileName.text = fullName
            binding.tvProfileDesc.text = it.aboutMe
            binding.tvUserEmail.text = it.email
        }, error = {
            Log.e("profile", it)
        })
    }

    override fun constructListeners() {
        binding.btnEditProfile.setOnClickListener {
            binding.refactorUserProfile.root.isVisible = true
            binding.profileContainer.isGone = true
            binding.btnLogout.isGone = true
            binding.btnEditProfile.isGone = true
        }

        binding.refactorUserProfile.btnSave.setOnClickListener {
            val newName = binding.refactorUserProfile.etName.text.toString()
            val newSurname = binding.refactorUserProfile.etSurname.text.toString()
            val newEmail = binding.refactorUserProfile.etEmail.text.toString()
            val newAboutMe = binding.refactorUserProfile.etAboutMe.text.toString()

            viewModel.updateUserProfile(UpdateUserProfileUI(
                firstName = newName,
                lastName =  newSurname,
                aboutMe = newAboutMe,
                email = newEmail
            ))

            viewModel.updateUserProfileState.spectateUiState(success = {
                binding.refactorUserProfile.root.isGone = true
                binding.profileContainer.isVisible = true
                binding.btnLogout.isVisible = true
                binding.btnEditProfile.isVisible = true
            }, error = {
                Log.e("ololo", it)
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            })
        }

        binding.refactorUserProfile.btnCancel.setOnClickListener {
            binding.refactorUserProfile.root.isGone = true
            binding.profileContainer.isVisible = true
            binding.btnLogout.isVisible = true
            binding.btnEditProfile.isVisible = true
        }

        binding.refactorUserProfile.imgRefactorProfileImage.setOnClickListener {
            findNavController().navigate(R.id.updateUserImageDialogFragment)
        }

    }
}