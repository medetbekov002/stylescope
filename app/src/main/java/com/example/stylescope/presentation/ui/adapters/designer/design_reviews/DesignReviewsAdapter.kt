package com.example.stylescope.presentation.ui.adapters.designer.design_reviews

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.stylescope.databinding.ItemReviewsBinding
import com.example.stylescope.presentation.model.designer.DesignReviewUI
import com.example.stylescope.presentation.utils.loadImage

class DesignReviewsAdapter :
    androidx.recyclerview.widget.ListAdapter<DesignReviewUI, DesignReviewsAdapter.DesignReviewsViewHolder>(
        CompanyReviewDiffCallback()
    ) {
    class CompanyReviewDiffCallback : DiffUtil.ItemCallback<DesignReviewUI>() {
        override fun areItemsTheSame(oldItem: DesignReviewUI, newItem: DesignReviewUI): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(
            oldItem: DesignReviewUI,
            newItem: DesignReviewUI
        ): Boolean =
            oldItem == newItem

    }

    class DesignReviewsViewHolder(private val binding: ItemReviewsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(model: DesignReviewUI) {
            binding.itemImgReviews.loadImage(model.user_photo)
            val rating = model.rank
            binding.itemRatingReviews.rating = rating.toFloat()
            binding.itemTvReviewsName.text = model.username
            binding.itemTextReviews.text = model.text
            binding.itemTvReviewsHoursAgo.text = model.time_since_published
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DesignReviewsViewHolder(
        ItemReviewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: DesignReviewsViewHolder, position: Int) {
        val model = getItem(position)
        holder.onBind(model)
    }
}

