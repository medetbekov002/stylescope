package com.example.stylescope.presentation.ui.adapters.company.company_service

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.stylescope.databinding.ItemPackageBinding
import com.example.stylescope.databinding.ItemServiceBinding
import com.example.stylescope.presentation.model.company.CompanyPackageUI
import com.example.stylescope.presentation.model.company.ServicesUI

class CompanyServiceAdapter : androidx.recyclerview.widget.ListAdapter<ServicesUI, CompanyServiceAdapter.CompanyServiceViewHolder>(
        CompanyPackageDiffCallback()
) {
    class CompanyPackageDiffCallback : DiffUtil.ItemCallback<ServicesUI>(){
        override fun areItemsTheSame(oldItem: ServicesUI, newItem: ServicesUI): Boolean =
                oldItem == newItem

        override fun areContentsTheSame(oldItem: ServicesUI, newItem: ServicesUI): Boolean =
                oldItem == newItem

    }

    class CompanyServiceViewHolder(private val binding: ItemServiceBinding) : ViewHolder(binding.root) {
        fun onBind(model: ServicesUI) {
            binding.itemTvPackageTitle.text = model.title

            var serviceDescState = false
            val serviceDesc = model.description

            binding.itemTvPackageTitle.setOnClickListener {
                if (!serviceDescState && !serviceDesc.isNullOrEmpty()) {
                    binding.itemTvPackageDesc.visibility = View.VISIBLE
                    binding.itemTvPackageDesc.text = model.description
                    serviceDescState = true
                } else {
                    binding.itemTvPackageDesc.visibility = View.GONE
                    serviceDescState = false
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CompanyServiceViewHolder(
        ItemServiceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )
    override fun onBindViewHolder(holder: CompanyServiceViewHolder, position: Int) {
        val model = getItem(position)
        holder.onBind(model)
    }
}
