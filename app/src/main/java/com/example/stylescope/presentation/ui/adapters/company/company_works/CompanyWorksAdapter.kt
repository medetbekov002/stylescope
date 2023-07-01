package com.example.stylescope.presentation.ui.adapters.company.company_works

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.stylescope.databinding.ItemCompanyWorksBinding
import com.example.stylescope.presentation.model.company.GalleryUI
import com.example.stylescope.presentation.utils.loadImage

class CompanyWorksAdapter :
    ListAdapter<GalleryUI, CompanyWorksAdapter.CompanyWorksViewHolder>(WorksDiffCallback()) {

    class WorksDiffCallback : DiffUtil.ItemCallback<GalleryUI>() {
        override fun areItemsTheSame(
            oldItem: GalleryUI,
            newItem: GalleryUI
        ): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(
            oldItem: GalleryUI,
            newItem: GalleryUI
        ): Boolean =
            oldItem == newItem

    }

    class CompanyWorksViewHolder(private val binding: ItemCompanyWorksBinding) :
        ViewHolder(binding.root) {
        fun onBind(model: GalleryUI?) {
            model?.image?.let { binding.itemImgCompanyWorks.loadImage(it) }
            binding.itemCompanyWorkName.text = model?.about
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