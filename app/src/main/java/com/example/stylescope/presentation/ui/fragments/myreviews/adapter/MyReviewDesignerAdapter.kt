package com.example.stylescope.presentation.ui.fragments.myreviews.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.stylescope.databinding.ItemCompaniesBinding
import com.example.stylescope.presentation.model.myreviews.DesignerReviewUI

class MyReviewDesignerAdapter(private val click: (id: Int) -> Unit) : ListAdapter<DesignerReviewUI, MyReviewDesignerAdapter.MyReviewsDesignerViewHolder>(
    CompanyDiffCallback()
) {
    class CompanyDiffCallback : DiffUtil.ItemCallback<DesignerReviewUI>(){
        override fun areItemsTheSame(oldItem: DesignerReviewUI, newItem: DesignerReviewUI): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: DesignerReviewUI, newItem: DesignerReviewUI): Boolean =
            oldItem == newItem

    }

    inner class MyReviewsDesignerViewHolder(private val binding: ItemCompaniesBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(model: DesignerReviewUI?) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyReviewsDesignerViewHolder(
        ItemCompaniesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: MyReviewsDesignerViewHolder, position: Int) {
        val model = getItem(position)
        holder.onBind(model)
    }
}