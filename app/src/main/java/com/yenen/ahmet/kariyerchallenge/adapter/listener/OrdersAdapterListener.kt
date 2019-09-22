package com.yenen.ahmet.kariyerchallenge.adapter.listener

import com.yenen.ahmet.kariyerchallenge.model.OrdersResponse

interface OrdersAdapterListener {
    fun onItemClick(item:OrdersResponse,position:Int)
}