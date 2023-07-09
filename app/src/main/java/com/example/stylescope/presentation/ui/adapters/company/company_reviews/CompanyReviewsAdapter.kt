package com.example.stylescope.presentation.ui.adapters.company.company_reviews

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.stylescope.databinding.ItemReviewsBinding
import com.example.stylescope.presentation.model.company.CompanyReviewUI
import com.example.stylescope.presentation.utils.loadImage


class CompanyReviewsAdapter :
        androidx.recyclerview.widget.ListAdapter<Int, CompanyReviewsAdapter.CompanyReviewsViewHolder>(
                CompanyReviewDiffCallback()
        ) {
    class CompanyReviewDiffCallback : DiffUtil.ItemCallback<Int>() {
        override fun areItemsTheSame(oldItem: Int, newItem: Int): Boolean =
                oldItem == newItem

        override fun areContentsTheSame(
                oldItem: Int,
                newItem: Int
        ): Boolean =
                oldItem == newItem
    }

    class CompanyReviewsViewHolder(private val binding: ItemReviewsBinding) :
            RecyclerView.ViewHolder(binding.root) {
        fun onBind(model: Int) {
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CompanyReviewsViewHolder(
            ItemReviewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: CompanyReviewsViewHolder, position: Int) {
        val model = getItem(position)
        holder.onBind(model)
    }
}
