package com.yenen.ahmet.kariyerchallenge.model

import android.view.View

data class OrdersResponse(
    val date: String,
    val month: String,
    val marketName: String,
    val orderName: String,
    val productPrice: Double,
    val productState: String,
    val productDetail: ProductDetail,
    var rowDetailVisibility: Int = 0
)


data class ProductDetail(
    val orderDetail: String,
    val summaryPrice: Double
)