package com.maxli.myapplication3.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import com.maxli.myapplication3.R
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
        binding.coinList.adapter = OverViewAdapter { id ->
            val bundle = Bundle()
            bundle.putString("id", id)
            NavHostFragment.findNavController(this)
            .navigate(R.id.detailFragment, bundle) }

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
