package com.example.testprojectxml

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testprojectxml.databinding.ActivityBakeryBinding

class BakeryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBakeryBinding
    private val bakeryItems = mutableListOf<String>()
    private lateinit var adapter: BakeryAdapter
    private var selectedIndex = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBakeryBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnAdd.setOnClickListener {
            val name = binding.etItemName.text.toString().trim()
            if (name.isNotEmpty()) {
                bakeryItems.add(name)
                setRecyclerview(bakeryItems)
                adapter.notifyItemInserted(bakeryItems.size - 1)
                binding.etItemName.text.clear()
            } else Toast.makeText(this, "Enter bakery item name", Toast.LENGTH_SHORT).show()
        }

        binding.btnUpdate.setOnClickListener {
            val name = binding.etItemName.text.toString().trim()
            if (selectedIndex != -1 && name.isNotEmpty()) {
                bakeryItems[selectedIndex] = name
                adapter.notifyItemChanged(selectedIndex)
                binding.etItemName.text.clear()
                selectedIndex = -1
            } else Toast.makeText(this, "Select an item to update", Toast.LENGTH_SHORT).show()
        }

        binding.btnDelete.setOnClickListener {
            if (selectedIndex != -1) {
                bakeryItems.removeAt(selectedIndex)
                adapter.notifyItemRemoved(selectedIndex)
                binding.etItemName.text.clear()
                selectedIndex = -1
            } else Toast.makeText(this, "Select an item to delete", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setRecyclerview(bakeryItems: MutableList<String>) {
        adapter = BakeryAdapter(bakeryItems) { name, index ->
            binding.etItemName.setText(name)
            selectedIndex = index
        }

        binding.rvBakeryItems.layoutManager = LinearLayoutManager(this)
        binding.rvBakeryItems.adapter = adapter

        adapter.notifyDataSetChanged()

    }
}
