package com.yenen.ahmet.kariyerchallenge.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yenen.ahmet.kariyerchallenge.adapter.listener.OrdersAdapterListener
import com.yenen.ahmet.kariyerchallenge.base.adapter.BaseRecyclerViewAdapter
import com.yenen.ahmet.kariyerchallenge.databinding.RowOrdersBinding
import com.yenen.ahmet.kariyerchallenge.model.OrdersResponse

class OrdersAdapter constructor(items: MutableList<OrdersResponse>) :
    BaseRecyclerViewAdapter<OrdersResponse, OrdersAdapter.ViewHolder>(items) {

    private var listener: OrdersAdapterListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RowOrdersBinding.inflate(getInflater(parent), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
            holder.binding.root.setOnClickListener { _ ->
                listener?.onItemClick(it, position)
            }
        }
    }


    class ViewHolder(val binding: RowOrdersBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: OrdersResponse) {
            binding.model = item
            binding.executePendingBindings()
        }
    }

    fun setListener(listener: OrdersAdapterListener) {
        this.listener = listener
    }

    fun unBind() {
        listener = null
    }


}