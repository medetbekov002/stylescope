package com.example.stylescope.presentation.ui.adapters.company.company_reviews

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.stylescope.databinding.ItemReviewsBinding
import com.example.stylescope.presentation.model.company.CompanyReviewUI
import com.example.stylescope.presentation.utils.loadImage


class CompanyReviewsAdapter :
        androidx.recyclerview.widget.ListAdapter<CompanyReviewUI, CompanyReviewsAdapter.CompanyReviewsViewHolder>(
                CompanyReviewDiffCallback()
        ) {
    class CompanyReviewDiffCallback : DiffUtil.ItemCallback<CompanyReviewUI>() {
        override fun areItemsTheSame(oldItem: CompanyReviewUI, newItem: CompanyReviewUI): Boolean =
                oldItem == newItem

        override fun areContentsTheSame(
                oldItem: CompanyReviewUI,
                newItem: CompanyReviewUI
        ): Boolean =
                oldItem == newItem

    }

    class CompanyReviewsViewHolder(private val binding: ItemReviewsBinding) :
            RecyclerView.ViewHolder(binding.root) {
        fun onBind(model: CompanyReviewUI) {
            model.user_photo?.let { binding.itemImgReviews.loadImage(it) }
            val rating = model.rank
            if (rating != null) {
                binding.itemRatingReviews.rating = rating.toFloat()
            }
            binding.itemTvReviewsName.text = model.username
            binding.itemTextReviews.text = model.text
            binding.itemTvReviewsHoursAgo.text = model.time_since_published
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
