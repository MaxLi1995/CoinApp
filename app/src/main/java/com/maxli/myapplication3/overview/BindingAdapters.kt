package com.maxli.myapplication3.overview

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.maxli.myapplication3.data.Data

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Data>?) {
    val adapter = recyclerView.adapter as OverViewAdapter
    adapter.submitList(data)
}