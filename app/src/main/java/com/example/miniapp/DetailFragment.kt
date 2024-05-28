package com.example.miniapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.miniapp.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding: FragmentDetailBinding get() = _binding!!

    private val viewModel by viewModels<DetailViewModel>()
    var adapter = ImageAdapter()

    val args: DetailFragmentArgs by navArgs()

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeData()
        val id = args.id
        viewModel.getProduct(id)
        binding.viewPager2.adapter = adapter

    }

    fun observeData() {
        viewModel.product.observe(viewLifecycleOwner) {
            binding.product = it
            adapter.updateMyList(it.images)
        }

        viewModel.loading.observe(viewLifecycleOwner) {
            if (it){
                binding.progressBar2.inVisible()
                binding.mainSide.gone()
            }else{
                binding.progressBar2.gone()
                binding.mainSide.toVisible()
            }
        }

    }
}