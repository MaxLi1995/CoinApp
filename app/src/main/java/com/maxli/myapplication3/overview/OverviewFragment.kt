package com.maxli.myapplication3.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.maxli.myapplication3.databinding.FragmentOverviewBinding

class OverviewFragment: Fragment() {

    private val viewModel: OverviewViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentOverviewBinding.inflate(inflater)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel
        binding.coinList.adapter = OverViewAdapter()

        binding.refreshLayout.setOnRefreshListener {
            viewModel.getData()
        }
        viewModel.isRefreshing.observe(viewLifecycleOwner){
            if (it != binding.refreshLayout.isRefreshing) {
                binding.refreshLayout.isRefreshing = it
            }
        }

        return binding.root
    }
}