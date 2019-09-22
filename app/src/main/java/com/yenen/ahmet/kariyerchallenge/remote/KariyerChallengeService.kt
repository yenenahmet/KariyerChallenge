package com.yenen.ahmet.kariyerchallenge.remote

import com.yenen.ahmet.kariyerchallenge.model.OrdersResponse
import io.reactivex.Flowable
import retrofit2.http.GET

interface KariyerChallengeService {

    @GET("/")
    fun getOrders(): Flowable<List<OrdersResponse>>

}