package com.example.natifetesttask.presentation.fragment

import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.OnScrollListener
import com.bumptech.glide.Glide
import com.example.natifetesttask.R
import com.example.natifetesttask.common.util.Constants.LIMIT_COUNT
import com.example.natifetesttask.common.util.result.asFailure
import com.example.natifetesttask.common.util.result.asSuccess
import com.example.natifetesttask.common.util.result.getErrorInfo
import com.example.natifetesttask.common.util.result.isSuccess
import com.example.natifetesttask.databinding.FragmentSerachGifsBinding
import com.example.natifetesttask.domain.params.SearchParams
import com.example.natifetesttask.domain.viewmodel.GifsViewModel
import com.example.natifetesttask.presentation.adapter.VerticalGifsAdapter
import com.example.natifetesttask.presentation.navigation.FragmentNavigation
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SearchGifsFragment: BaseFragment(R.layout.fragment_serach_gifs) {
    private val binding by viewBinding<FragmentSerachGifsBinding>()

    private val gifsViewModel: GifsViewModel by viewModels { viewModelFactory }

    private lateinit var verticalGifsAdapter: VerticalGifsAdapter

    private var doubleBackToExitPressedOnce = false

    private var isLoading: Boolean = false

    private var currentGifsLoaded = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        handleOnBackPressed()
        initAdapter()
        initListeners()
    }

    private fun initAdapter() {
        verticalGifsAdapter = VerticalGifsAdapter(requireContext()) { position ->
            selectedGif(
                position
            )
        }
        binding.rvGifs.adapter = verticalGifsAdapter
        binding.rvGifs.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }

    private fun initListeners() {
        binding.etSearch.doOnTextChanged { text, _, _, _ ->
            currentGifsLoaded = 0
            verticalGifsAdapter.removeAllGifs()
            loadGifs(text.toString(), currentGifsLoaded, true)
        }

        binding.rvGifs.addOnScrollListener(object : OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)

                if (!isLoading && !recyclerView.canScrollVertically(1)) {
                    isLoading = true
                    loadGifs(binding.etSearch.text.toString(), currentGifsLoaded, false)
                }
            }
        })
    }

    private fun loadGifs(text: String, offset: Int, shouldClear: Boolean) {
        gifsViewModel.gifsSearch(SearchParams(text, LIMIT_COUNT, offset)).observe(viewLifecycleOwner) {
            when(it.isSuccess()) {
                true -> {
                    if (it.asSuccess().value.pagination.totalCount == 0 && text.isNotEmpty()) {
                        managePlaceholder(PlaceholderType.NOT_FOUND)
                    } else if (text.isEmpty()) {
                        managePlaceholder(PlaceholderType.EMPTY)
                    }
                    else {
                        showGifs()
                        if (shouldClear) {
                            verticalGifsAdapter.removeAllGifs()
                        }
                        verticalGifsAdapter.addGifsToGifList(it.asSuccess().value.data.toMutableList())
                        currentGifsLoaded += LIMIT_COUNT
                    }
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

    private fun managePlaceholder(placeholderType: PlaceholderType) {
        binding.rvGifs.visibility = View.GONE
        binding.llPlaceholder.visibility = View.VISIBLE
        when(placeholderType) {
            PlaceholderType.EMPTY -> {
                binding.tvPlaceholder.text = getString(R.string.start_typing)
                Glide.with(requireActivity().applicationContext)
                    .load(R.drawable.start_typing)
                    .into(binding.ivPlaceholder)
            }
            PlaceholderType.NOT_FOUND -> {
                binding.tvPlaceholder.text = getString(R.string.not_found_error)
                Glide.with(requireActivity().applicationContext)
                    .load(R.drawable.not_found_city)
                    .into(binding.ivPlaceholder)
            }
        }
    }

    private fun showGifs() {
        binding.rvGifs.visibility = View.VISIBLE
        binding.llPlaceholder.visibility = View.GONE
    }

    private fun selectedGif(position: Int) {
        FragmentNavigation.navigateToSelectedGiftFragment(parentFragmentManager, position, binding.etSearch.text.toString())
    }

    private fun handleOnBackPressed() {
        requireActivity()
            .onBackPressedDispatcher
            .addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    if (doubleBackToExitPressedOnce) {
                        requireActivity().finishAffinity()
                        return
                    }

                    this@SearchGifsFragment.doubleBackToExitPressedOnce = true
                    Toast.makeText(requireActivity().applicationContext, getString(R.string.click_again_to_exit_app), Toast.LENGTH_SHORT).show()

                    CoroutineScope(Dispatchers.IO).launch {
                        delay(2000L)
                        doubleBackToExitPressedOnce = false
                    }
                }
            }
            )
    }

    enum class PlaceholderType {
        EMPTY,
        NOT_FOUND
    }

    companion object {

        fun newInstance() =
            SearchGifsFragment()
    }
}