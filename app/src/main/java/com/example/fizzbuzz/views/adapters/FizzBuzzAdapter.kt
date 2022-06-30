package com.example.fizzbuzz.views.adapters

import android.view.*
import androidx.recyclerview.widget.RecyclerView
import com.example.fizzbuzz.databinding.ItemFizzBuzzBinding

class FizzBuzzAdapter : RecyclerView.Adapter<FizzBuzzAdapter.ViewHolder>() {
    private val list = mutableListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ItemFizzBuzzBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]

        holder.binding.text = item
    }

    override fun getItemCount(): Int = list.size

    fun addData(newList: List<String>) {
        val endPosition = list.size
        list.addAll(newList)

        notifyItemRangeInserted(endPosition, newList.size)
    }

    class ViewHolder(val binding: ItemFizzBuzzBinding) : RecyclerView.ViewHolder(binding.root)
}