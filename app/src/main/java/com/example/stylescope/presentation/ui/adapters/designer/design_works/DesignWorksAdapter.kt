package com.example.stylescope.presentation.ui.adapters.designer.design_works

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.stylescope.databinding.ItemCompanyWorksBinding
import com.example.stylescope.presentation.model.designer.DesignerGalleryUI
import com.example.stylescope.presentation.utils.loadImage

class DesignWorksAdapter :
    ListAdapter<DesignerGalleryUI, DesignWorksAdapter.CompanyWorksViewHolder>(WorksDiffCallback()) {

    class WorksDiffCallback : DiffUtil.ItemCallback<DesignerGalleryUI>() {
        override fun areItemsTheSame(
            oldItem: DesignerGalleryUI,
            newItem: DesignerGalleryUI
        ): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(
            oldItem: DesignerGalleryUI,
            newItem: DesignerGalleryUI
        ): Boolean =
            oldItem == newItem

    }

    class CompanyWorksViewHolder(private val binding: ItemCompanyWorksBinding) :
        ViewHolder(binding.root) {
        fun onBind(model: DesignerGalleryUI?) {
            model?.image?.let { binding.itemImgCompanyWorks.loadImage(it) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CompanyWorksViewHolder(
        ItemCompanyWorksBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: CompanyWorksViewHolder, position: Int) {
        val model = getItem(position)
        holder.onBind(model)
    }
}