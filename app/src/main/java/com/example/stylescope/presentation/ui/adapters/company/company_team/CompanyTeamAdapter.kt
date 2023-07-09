package com.example.stylescope.presentation.ui.adapters.company.company_team

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.stylescope.databinding.ItemDesignersBinding
import com.example.stylescope.presentation.model.company.CompanyDesignerUI
import com.example.stylescope.presentation.utils.loadImage

class CompanyTeamAdapter : ListAdapter<CompanyDesignerUI, CompanyTeamAdapter.CompanyTeamViewHolder>(
    TeamDiffCallback()
) {
    class TeamDiffCallback : DiffUtil.ItemCallback<CompanyDesignerUI>() {
        override fun areItemsTheSame(oldItem: CompanyDesignerUI, newItem: CompanyDesignerUI): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: CompanyDesignerUI, newItem: CompanyDesignerUI): Boolean =
            oldItem == newItem

    }

    class CompanyTeamViewHolder(private val binding: ItemDesignersBinding) : ViewHolder(binding.root) {
        fun onBind(model: CompanyDesignerUI?) {
            model?.photo?.let { binding.itemImgEmployee.loadImage(it) }
            binding.itemTvEmployeeName.text = model?.name
            binding.itemTvEmployeeProfession.text = model?.occupation
            binding.itemTvRating.text = model?.rating
            val rating = model?.rating?.toFloat()
            binding.itemRatingBar.rating = rating!!

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CompanyTeamViewHolder(
        ItemDesignersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: CompanyTeamViewHolder, position: Int) {
        val model = getItem(position)
        holder.onBind(model)
    }
}