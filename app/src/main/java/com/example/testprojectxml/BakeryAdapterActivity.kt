package com.example.testprojectxml

import com.example.testprojectxml.databinding.ItemBakeryBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class BakeryAdapter(
    private val items: List<String>,
    private val onItemClick: (String, Int) -> Unit
) : RecyclerView.Adapter<BakeryAdapter.BakeryViewHolder>() {

    inner class BakeryViewHolder(private val binding: ItemBakeryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(name: String, position: Int) {
            binding.tvItemName.text = items[position]
            binding.root.setOnClickListener {
                onItemClick(name, position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BakeryViewHolder {
        val binding = ItemBakeryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BakeryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BakeryViewHolder, position: Int) {
        holder.bind(items[position], position)
    }

    override fun getItemCount() = items.size
}



