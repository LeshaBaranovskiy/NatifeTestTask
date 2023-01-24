package com.example.natifetesttask.presentation.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.natifetesttask.R
import com.example.natifetesttask.common.util.Constants.LIMIT_COUNT
import com.example.natifetesttask.common.util.result.asFailure
import com.example.natifetesttask.common.util.result.asSuccess
import com.example.natifetesttask.common.util.result.getErrorInfo
import com.example.natifetesttask.common.util.result.isSuccess
import com.example.natifetesttask.databinding.FragmentSelectedGifBinding
import com.example.natifetesttask.domain.model.entity.Gif
import com.example.natifetesttask.domain.params.SearchParams
import com.example.natifetesttask.domain.viewmodel.GifsViewModel
import com.example.natifetesttask.domain.viewmodel.SharedDataViewModel
import com.example.natifetesttask.presentation.adapter.HorizontalGifsAdapter

class SelectedGifFragment: BaseFragment(R.layout.fragment_selected_gif) {
    private val binding by viewBinding<FragmentSelectedGifBinding>()

    private val gifsViewModel: GifsViewModel by viewModels { viewModelFactory }

    private lateinit var adapter: HorizontalGifsAdapter

    private val sharedDataViewModel: SharedDataViewModel by activityViewModels()

    private var offset: Int? = 0
    private var text: String = ""

    private val snapHelper = PagerSnapHelper()

    private var isLoading: Boolean = false
    private var currentGifsLoaded = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        offset = arguments?.getInt(ARG_OFFSET)
        text = arguments?.getString(ARG_TEXT).toString()

        initAdapter()
        initData()
        initListeners()
    }

    private fun initListeners() {
        binding.rvGifs.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)

                if (!isLoading && !recyclerView.canScrollHorizontally(1)) {
                    isLoading = true
                    loadGifs(text, currentGifsLoaded)
                }
            }
        })
    }

    private fun initAdapter() {
        adapter = HorizontalGifsAdapter(requireActivity().applicationContext)
        binding.rvGifs.adapter = adapter
        binding.rvGifs.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        snapHelper.attachToRecyclerView(binding.rvGifs)
    }

    private fun initData() {
        loadGifs(text, offset)
    }

    private fun loadGifs(text: String, offset: Int?) {
        gifsViewModel.gifsSearch(SearchParams(text, LIMIT_COUNT, offset ?: 0)).observe(viewLifecycleOwner) {
            when(it.isSuccess()) {
                true -> {
                    val checkedGifs: MutableList<Gif> = mutableListOf()

                    if (sharedDataViewModel.blackList.value != null && sharedDataViewModel.blackList.value!!.size > 0) {
                        with(it.asSuccess().value) {
                            for (i in data.indices) {
                                for (blackListedItemIter in 0 until sharedDataViewModel.blackList.value!!.size) {
                                    if (data[i].id == sharedDataViewModel.blackList.value!![blackListedItemIter].gifId) {
                                        break
                                    }
                                    if (blackListedItemIter == sharedDataViewModel.blackList.value!!.size - 1) {
                                        checkedGifs.add(data[i])
                                    }
                                }
                            }
                        }
                        adapter.addGifsToGifList(checkedGifs)
                    } else {
                        adapter.addGifsToGifList(it.asSuccess().value.data.toMutableList())
                    }
                    currentGifsLoaded += LIMIT_COUNT
                    isLoading = false
                }

                false -> {
                    Log.d("error", it.asFailure().getErrorInfo().message)
                    Log.d("error", it.asFailure().getErrorInfo().code.toString())
                    isLoading = false
                }
            }
        }
    }

    companion object {
        private const val ARG_OFFSET = "ARG_CITY"
        private const val ARG_TEXT = "ARG_TEXT"

        fun newInstance(offset: Int, text: String) : SelectedGifFragment {
            val bundle = Bundle()
            bundle.putInt(ARG_OFFSET, offset)
            bundle.putString(ARG_TEXT, text)
            val fragment = SelectedGifFragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}