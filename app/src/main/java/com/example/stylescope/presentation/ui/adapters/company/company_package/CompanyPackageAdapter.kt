package com.example.stylescope.presentation.ui.adapters.company.company_package

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.stylescope.databinding.ItemPackageBinding
import com.example.stylescope.presentation.model.company.CompanyPackageUI

class CompanyPackageAdapter : androidx.recyclerview.widget.ListAdapter<CompanyPackageUI, CompanyPackageAdapter.CompanyPackageViewHolder>(
        CompanyPackageDiffCallback()
) {
    class CompanyPackageDiffCallback : DiffUtil.ItemCallback<CompanyPackageUI>(){
        override fun areItemsTheSame(oldItem: CompanyPackageUI, newItem: CompanyPackageUI): Boolean =
                oldItem == newItem

        override fun areContentsTheSame(oldItem: CompanyPackageUI, newItem: CompanyPackageUI): Boolean =
                oldItem == newItem

    }

    class CompanyPackageViewHolder(private val binding: ItemPackageBinding) : ViewHolder(binding.root) {
        fun onBind(model: CompanyPackageUI) {
            binding.itemTvPackageTitle.text = model.title

            var serviceDescState = false
            val serviceDesc = model.description

            binding.itemTvPackageTitle.setOnClickListener {
                Log.w("ololo", "onBind: ${model.description}", )

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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CompanyPackageViewHolder(
            ItemPackageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )
    override fun onBindViewHolder(holder: CompanyPackageViewHolder, position: Int) {
        val model = getItem(position)
        holder.onBind(model)
    }
}
