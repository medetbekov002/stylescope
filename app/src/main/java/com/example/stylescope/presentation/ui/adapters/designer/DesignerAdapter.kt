package com.example.stylescope.presentation.ui.adapters.designer

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.stylescope.databinding.ItemDesignersBinding
import com.example.stylescope.presentation.model.designer.DesignerUI
import com.example.stylescope.presentation.utils.loadImage

class DesignerAdapter(
    private val click: (id: Int) -> Unit) :
    ListAdapter<DesignerUI, DesignerAdapter.DesignerViewHolder>(
        DesignerDiffCallback()
    ) {
    class DesignerDiffCallback : DiffUtil.ItemCallback<DesignerUI>() {
        override fun areItemsTheSame(oldItem: DesignerUI, newItem: DesignerUI): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: DesignerUI, newItem: DesignerUI): Boolean =
            oldItem == newItem

    }

    inner class DesignerViewHolder(private val binding: ItemDesignersBinding) :
        ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun onBind(model: DesignerUI?) {
            if (model != null) {
                model.photo.let { binding.itemImgEmployee.loadImage(it!!) }
                binding.itemTvEmployeeName.text = "${model.name}" + " " + "${model.surname}"
                binding.itemTvEmployeeProfession.text = model.occupation
                binding.itemTvRating.text = model.rating.toString()
                val rating = model.rating!!.toFloat()
                binding.itemRatingBar.rating = rating

                itemView.setOnClickListener {
                    click(model.id!!)
                    Log.w("ololo", "click: $model.id")
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DesignerViewHolder(
        ItemDesignersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: DesignerViewHolder, position: Int) {
        val model = getItem(position)
        holder.onBind(model)
    }

}