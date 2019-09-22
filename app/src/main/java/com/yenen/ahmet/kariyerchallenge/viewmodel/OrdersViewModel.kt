package com.yenen.ahmet.kariyerchallenge.viewmodel

import com.yenen.ahmet.kariyerchallenge.adapter.OrdersAdapter
import com.yenen.ahmet.kariyerchallenge.base.viewmodel.BaseRxSingleHandlerViewModel
import com.yenen.ahmet.kariyerchallenge.local.SharedPreferencesHelper
import com.yenen.ahmet.kariyerchallenge.model.OrdersResponse
import com.yenen.ahmet.kariyerchallenge.remote.KariyerChallengeService
import io.reactivex.Flowable
import javax.inject.Inject

// Neden MVVM, LiveData, DataBinding Kütüphaneleri?
// Bloğumdan ulaşabilirsiniz  detaylı olarak anlattım
// https://medium.com/@ynnahmet/mvvm-livedata-databinding-yap%C4%B1s%C4%B1-kullan%C4%B1m%C4%B1-c9ba04593c12

class OrdersViewModel @Inject constructor(
    private val service: KariyerChallengeService,
    private val sharedPreferencesHelper: SharedPreferencesHelper
) :
    BaseRxSingleHandlerViewModel<List<OrdersResponse>>() {


    //  Neden Sadece  Klasik Çağrı Yapıp, Yönetimi direkt livedataya bırakmadık ?
    // RxJava zip,merge gibi operatörlerine ihtiyacımız olabiliyor. Örnek
    //  eğer aynı sayfa üzerinden birden fazla çağrı yapıp
    //  hepsini aynı anda işlemek istiyorsak Zip operatörünü kullanmamız gerekecek.
    override fun getServiceFlowable(): Flowable<List<OrdersResponse>> {
        return service.getOrders()
    }

    val adapter by lazy {
        OrdersAdapter(mutableListOf())
    }

    fun setItemsAdapter(items: List<OrdersResponse>) {
        if (items.isNotEmpty()) {
            adapter.setItems(items)
        } else {
            noDataFound.value = noDataFoundText
        }
    }


    fun removeRememberMe() {
        sharedPreferencesHelper.removeRememberMe()
    }

    override fun onCleared() {
        super.onCleared()
        adapter.unBind()
    }


}