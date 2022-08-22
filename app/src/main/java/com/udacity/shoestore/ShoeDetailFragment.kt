package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe

class ShoeDetailFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailBinding
    private val shoesViewModel: ShoesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShoeDetailBinding.inflate(inflater)

        with(binding) {
            lifecycleOwner = this@ShoeDetailFragment
            shoe = Shoe("", 0.0, "", "")
            viewModel = shoesViewModel
        }

        binding.cancelButton.setOnClickListener {
            findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
        }

        shoesViewModel.eventCancel.observe(viewLifecycleOwner) { canceled ->
            if (canceled) {
                findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
                shoesViewModel.onEventCancelComplete()
            }
        }

        shoesViewModel.eventSave.observe(viewLifecycleOwner) { saved ->
            if (saved) {
                findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
                shoesViewModel.onEventSaveComplete()
            }
        }

        return binding.root
    }
}