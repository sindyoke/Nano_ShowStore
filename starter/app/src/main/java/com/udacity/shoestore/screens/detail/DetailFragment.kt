package com.udacity.shoestore.screens.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.screens.list.ListViewModel

class DetailFragment : Fragment() {

    private val viewModel: ListViewModel by activityViewModels()
    lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(
            inflater,
            container,
            false)
        binding.lifecycleOwner = this
        binding.listViewModel = viewModel
        binding.shoe = Shoe("", 0.0, "", "")

        binding.btnCancel.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.btnSave.setOnClickListener {
            val enteredShoe: Shoe = binding.shoe as Shoe
            if(enteredShoe.name.isNotEmpty()){
                viewModel.addShoe(binding.shoe)
                findNavController().navigateUp()
            } else {
                Toast.makeText(activity, "You cannot save empty shoe!", Toast.LENGTH_SHORT).show()
            }
        }
        return binding.root
    }
}