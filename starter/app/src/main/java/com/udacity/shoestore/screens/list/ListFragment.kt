package com.udacity.shoestore.screens.list

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentListBinding
import com.udacity.shoestore.models.Shoe

class ListFragment : Fragment() {

    private val viewModel: ListViewModel by activityViewModels()
    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater, container, false)

        binding.listViewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.navigateToDetail.observe(viewLifecycleOwner, {
            findNavController().navigate(R.id.action_listFragment_to_detailFragment)
        })

        viewModel.list.observe(viewLifecycleOwner, {
            if (it.isNotEmpty()) {
                loadList(it)
            }
        })
        setHasOptionsMenu(true)
        return binding.root
    }

    private fun loadList(list: List<Shoe>) {
        context?.let { context ->
            val listContainer = binding.llItems
            list.forEach { shoe ->
                val itemLayout = ItemLayout(context)
                itemLayout.loadShoe(shoe)
                listContainer.addView(itemLayout)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.logout) {
            findNavController().navigate(R.id.toLoginFragment)
            return true
        }
        return false
    }
}