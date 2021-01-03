package com.sam.foodmenudemoapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.sam.foodmenudemoapp.R
import com.sam.foodmenudemoapp.databinding.FragmentTopViewpagerBinding

class TopViewPagerFragment : Fragment() {

    companion object {
        private const val ARG_POSITION = "ARG_POSITION"

        fun getInstance(position: Int) = TopViewPagerFragment()
            .apply {
            arguments = bundleOf(ARG_POSITION to position)
        }
    }

    private lateinit var binding: FragmentTopViewpagerBinding

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentTopViewpagerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val position = requireArguments().getInt(ARG_POSITION)
        val restuarantImages = getRestaurantImages()
        with(binding) {
            restuarantImage.setImageResource(restuarantImages[position])
        }
    }

    private fun getRestaurantImages(): List<Int> {
        val restaurantAssets: MutableList<Int> = ArrayList()
        restaurantAssets.add(R.raw.image1)
        restaurantAssets.add(R.raw.image2)
        restaurantAssets.add(R.raw.image3)
        return restaurantAssets
    }
}