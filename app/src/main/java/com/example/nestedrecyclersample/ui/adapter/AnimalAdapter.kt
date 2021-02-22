package com.example.nestedrecyclersample.ui.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import coil.load
import com.example.nestedrecyclersample.R
import com.example.nestedrecyclersample.data.domain.Animal
import com.example.nestedrecyclersample.ui.adapter.base.BaseAdapter

class AnimalAdapter(
    items: List<Animal> = emptyList(),
) : BaseAdapter<Animal>(
    R.layout.item_animal,
    items,
) {
    override fun bind(itemView: View, item: Animal, position: Int, viewHolder: BaseViewHolderImp) {
        itemView.run {
            findViewById<TextView>(R.id.titleTextView)?.text = item.name
            findViewById<ImageView>(R.id.imageView)?.load(item.image)
        }
    }
}
