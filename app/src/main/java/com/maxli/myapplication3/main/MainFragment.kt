package com.maxli.myapplication3.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import coil.load
import coil.transform.CircleCropTransformation
import com.maxli.myapplication3.R
import com.maxli.myapplication3.databinding.MainFragmentBinding

class MainFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = MainFragmentBinding.inflate(inflater)

        binding.lifecycleOwner = this
        binding.homeButton.setOnClickListener {
            findNavController(this).navigate(R.id.overviewFragment)
        }
        binding.homePic.load(R.drawable.cat) {
            transformations(CircleCropTransformation())
        }
        return binding.root
    }
}