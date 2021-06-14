package com.gilbertopapa.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gilbertopapa.core.utils.Status
import com.gilbertopapa.home.databinding.FragmentHomeBinding
import com.gilbertopapa.network.source.remote.local.Resource
import com.gilbertopapa.ui.BaseFragment
import com.gilbertopapa.view.gone
import com.gilbertopapa.view.visible
import org.koin.android.viewmodel.ext.android.viewModel


class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override val inflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate
    private val homeViewModel: HomeViewModel by viewModel()
    private val homeAdapter = HomeAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        setupGameList()
        initObserver()

//        homeAdapter.onClickListenerItem = {
//            val intent = Intent(activity, DetailActivity::class.java)
//            intent.putExtra("extra_detail", it)
//            startActivity(intent)
//        }
    }

    private fun setupGameList() {
        binding.rvHorizontalGame.adapter = homeAdapter
    }

    private fun initViews() {
        binding.notificationLoading.visible()
        binding.notificationError.root.gone()
        binding.rvHorizontalGame.gone()
    }

    private fun initObserver() {
        homeViewModel.games.observe(viewLifecycleOwner, {
            if (it != null) {
                when (it) {
                    is Resource.Loading -> {
                        statusLayoutVisibility(Status.Loading)
                    }
                    is Resource.Success -> {
                        it.data?.let { it1 -> homeAdapter.setData(it1) }
                        statusLayoutVisibility(Status.Success)
                    }
                    is Resource.Error -> {
                        statusLayoutVisibility(Status.Error)
                    }
                }
            }
        })
    }

    private fun statusLayoutVisibility(status: Status) {
        binding.notificationLoading.gone()
        binding.notificationError.root.gone()
        binding.rvHorizontalGame.gone()

        when (status) {
            Status.Success -> {
                binding.rvHorizontalGame.visible()
            }
            Status.Error -> {
                binding.notificationError.root.visible()
            }
            Status.Loading -> {
                binding.notificationLoading.visible()
            }
        }
    }


//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        _fragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false)
//        return fragmentHomeBinding.root
//    }

//    override fun onDestroyView() {
//        super.onDestroyView()
//        _fragmentHomeBinding = null
//    }
}