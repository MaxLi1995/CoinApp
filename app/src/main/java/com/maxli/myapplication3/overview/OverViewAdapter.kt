package com.maxli.myapplication3.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.maxli.myapplication3.data.*
import com.maxli.myapplication3.databinding.OverviewItemBinding

class OverViewAdapter(private val callBack: (String)->Unit) : ListAdapter<Data, OverViewAdapter.DataViewHolder>(
    DiffCallback
) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        return DataViewHolder(OverviewItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val data = getItem(position)
        holder.bind(data)
        holder.itemView.setOnClickListener {
            callBack(data.id)
        }
    }

    class DataViewHolder(private var binding: OverviewItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Data){
            binding.name = data.symbol
            binding.fullName = data.name
            binding.money = data.getFormattedPrice()
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Data>() {
        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem.price == newItem.price && oldItem.symbol == newItem.symbol
        }

    }



}