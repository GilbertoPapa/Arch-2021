package com.gilbertopapa.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gilbertopapa.home.databinding.FragmentHomeBinding
import com.gilbertopapa.network.enums.Status
import com.gilbertopapa.network.local.Resource
import com.gilbertopapa.ui.BaseViewBindingFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseViewBindingFragment<FragmentHomeBinding>() {

    override val inflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate

    private val homeViewModel: HomeViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.notificationLoading.visibility = View.VISIBLE
        binding.notificationError.root.visibility = View.GONE
        binding.rvHorizontalGame.visibility = View.GONE
        val homeAdapter = HomeAdapter()
        binding.rvHorizontalGame.adapter = homeAdapter
        homeViewModel.games.observe(viewLifecycleOwner, {
            if (it != null) {
                when (it) {
                    is Resource.Loading -> {
                        statusLayoutVisibility(Status.Loading)
                    }
                    is Resource.Success -> {
                        it.data?.let { game -> homeAdapter.setData(game) }
                        statusLayoutVisibility(Status.Success)
                    }
                    is Resource.Error -> {
                        statusLayoutVisibility(Status.Error)
                    }
                }
            }
        })
//        homeAdapter.onClickListenerItem = {
//            val intent = Intent(activity, DetailActivity::class.java)
//            intent.putExtra("extra_detail", it)
//            startActivity(intent)
//        }
    }

    private fun statusLayoutVisibility(status: Status) {
        binding.notificationLoading.visibility = View.GONE
        binding.notificationError.root.visibility = View.GONE
        binding.rvHorizontalGame.visibility = View.GONE

        when (status) {
            Status.Success -> {
                binding.rvHorizontalGame.visibility = View.VISIBLE
            }
            Status.Error -> {
                binding.notificationError.root.visibility = View.VISIBLE
            }
            Status.Loading -> {
                binding.notificationLoading.visibility = View.VISIBLE
            }
        }
    }
}