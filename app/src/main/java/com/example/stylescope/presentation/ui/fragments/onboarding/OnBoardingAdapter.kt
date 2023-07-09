package com.example.stylescope.presentation.ui.fragments.onboarding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.stylescope.R
import com.example.stylescope.databinding.ItemOnBoardingBinding
import com.example.stylescope.presentation.model.OnBoarding
import com.google.android.material.textview.MaterialTextView

class OnBoardingAdapter(private val click: () -> Unit,private val backClick: () -> Unit,private val lastClick: () -> Unit) : RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    private val arrayList = arrayListOf(
        OnBoarding(
            isBack = false,
            title = "Удобство",
            desc = "Мы предоставляем удобный и быстрый способ найти лучшие дизайнерские услуги в Кыргызстане и получить профессиональную помощь в создании уникального пространства.",
            img = R.drawable.on_boarding_img_1,
            false
        ),
        OnBoarding(
            isBack = true,
            title = "Качество",
            desc = "Мы тщательно отбираем компании и дизайнеров, чтобы предоставлять только высококачественные услуги, гарантируя тем самым, что наши клиенты получат лучшее в своей отрасли",
            img = R.drawable.on_boarding_img_2,
            false
        ),
        OnBoarding(
            isBack = true,
            title = "Выбор",
            desc = "Мы предоставляем широкий спектр услуг дизайна интерьера и экстерьера компаний, включая проектирование, меблировку, подбор материалов, декорирование, ремонт, обучение.",
            img = R.drawable.on_boarding_img_3,
            true
        ),
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemOnBoardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = arrayList.size

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(arrayList[position])
    }


    inner class OnBoardingViewHolder(private val binding: ItemOnBoardingBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(onBoarding: OnBoarding) {
            with(binding) {
                btnBack.setOnClickListener {
                    backClick.invoke()
                }
                btnNext.setOnClickListener {
                  if (arrayList.last().isLast) {
                      lastClick.invoke()
                  } else {
                      click.invoke()
                  }
                }
                tvTitle.text = onBoarding.title
                tvDesc.text = onBoarding.desc
                imgMain.setImageResource(onBoarding.img)
                btnBack.isVisible = onBoarding.isBack
            }

        }
    }
}