package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding

class ShoeDetailFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailBinding
    private val viewModel: ShoesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShoeDetailBinding.inflate(inflater)

        binding.cancelButton.setOnClickListener {
            findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
        }

        binding.saveButton.setOnClickListener {
            val name =
                if (binding.shoeNameEdit.text.isNotEmpty()) binding.shoeNameEdit.text.toString() else "Name"
            val size =
                if (binding.shoeSizeEdit.text.isNotEmpty()) binding.shoeSizeEdit.text.toString() else "45.0"
            val company =
                if (binding.shoeCompanyEdit.text.isNotEmpty()) binding.shoeCompanyEdit.text.toString() else "Company"
            val description =
                if (binding.shoeDescriptionEdit.text.isNotEmpty()) binding.shoeDescriptionEdit.text.toString() else resources.getString(
                    R.string.lorem_ipsum
                )
            viewModel.addShoe(name, size, company, description)
            findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
        }

        return binding.root
    }
}