package com.example.stylescope.presentation.ui.fragments.about_us

import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.stylescope.R
import com.example.stylescope.core.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.stylescope.databinding.FragmentAboutUsBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class AboutUsFragment :
    BaseFragment<FragmentAboutUsBinding, AboutUsViewModel>(R.layout.fragment_about_us) {
    override val viewModel: AboutUsViewModel by viewModel()
    override val binding: FragmentAboutUsBinding by viewBinding(FragmentAboutUsBinding::bind)

    private val callback = OnMapReadyCallback { googleMap ->
        val myLocation = LatLng(42.879087, 74.6157687)
        googleMap.addMarker(MarkerOptions().position(myLocation).title("Marker in Bishkek"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(myLocation))
    }


    override fun constructListeners() {
        val mapFragment = childFragmentManager.findFragmentById(R.id.img_map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }

}