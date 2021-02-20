package com.udacity.shoestore.screens.list

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ItemListBinding
import com.udacity.shoestore.models.Shoe

class ItemLayout: LinearLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    private val binding: ItemListBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_list, this, false)

    fun loadShoe(shoe: Shoe) {
        binding.shoe = shoe
        binding.apply {
            addView(this.root)
            shoeName.text = shoe.name
            companyName.text = shoe.company
            shoeSize.text = shoe.size.toString()
            description.text = shoe.description
        }
    }
}
