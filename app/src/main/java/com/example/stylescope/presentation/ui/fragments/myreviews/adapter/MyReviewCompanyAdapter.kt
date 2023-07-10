package com.example.stylescope.presentation.ui.fragments.myreviews.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.stylescope.databinding.ItemCompaniesBinding
import com.example.stylescope.presentation.model.company.CompanyReviewUI


class MyReviewCompanyAdapter(private val click: (id: Int) -> Unit) : ListAdapter<CompanyReviewUI,MyReviewCompanyAdapter.MyReviewsCompanyViewHolder>(
    CompanyDiffCallback()
) {
    class CompanyDiffCallback : DiffUtil.ItemCallback<CompanyReviewUI>(){
        override fun areItemsTheSame(oldItem: CompanyReviewUI, newItem: CompanyReviewUI): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: CompanyReviewUI, newItem: CompanyReviewUI): Boolean =
            oldItem == newItem

    }

    inner class MyReviewsCompanyViewHolder(private val binding: ItemCompaniesBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(model: CompanyReviewUI?) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyReviewsCompanyViewHolder(
        ItemCompaniesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: MyReviewsCompanyViewHolder, position: Int) {
        val model = getItem(position)
        holder.onBind(model)
    }
}