package com.maxli.myapplication3.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import coil.load
import coil.transform.CircleCropTransformation
import com.maxli.myapplication3.R
import com.maxli.myapplication3.databinding.DetailFragmentBinding
import com.maxli.myapplication3.databinding.MainFragmentBinding
import com.maxli.myapplication3.overview.OverviewViewModel

class DetailFragment: Fragment() {

    private val viewModel: DetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val id = arguments?.getString("id")
        val binding = DetailFragmentBinding.inflate(inflater)

        binding.lifecycleOwner = this
        if (id != null) {
            viewModel.getData(id)
        }
        binding.viewModel = viewModel

        binding.detailRefresh.setOnRefreshListener {
            if (id != null) {
                viewModel.getData(id)
            }
        }
        viewModel.isRefreshing.observe(viewLifecycleOwner){
            if (it != binding.detailRefresh.isRefreshing) {
                binding.detailRefresh.isRefreshing = it
            }
        }

        return binding.root
    }
}