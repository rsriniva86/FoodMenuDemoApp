package com.sam.foodmenudemoapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.sam.foodmenudemoapp.databinding.FragmentViewpagerBinding

class ViewPagerFragment : Fragment() {

    companion object {
        private const val ARG_POSITION = "ARG_POSITION"

        fun getInstance(position: Int) = ViewPagerFragment().apply {
            arguments = bundleOf(ARG_POSITION to position)
        }
    }

    private lateinit var binding: FragmentViewpagerBinding

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentViewpagerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val position = requireArguments().getInt(ARG_POSITION)
        val onBoardingImages = getOnBoardAssetsLocation()
        with(binding) {
            onBoardingImage.setImageResource(onBoardingImages[position])
        }
    }

    private fun getOnBoardAssetsLocation(): List<Int> {
        val onBoardAssets: MutableList<Int> = ArrayList()
        onBoardAssets.add(R.raw.on_board_img1_land)
        onBoardAssets.add(R.raw.on_board_img2_land)
        onBoardAssets.add(R.raw.on_board_img3_land)
        return onBoardAssets
    }
}