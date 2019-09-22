package com.yenen.ahmet.kariyerchallenge.binding

import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.RecyclerView
import com.yenen.ahmet.kariyerchallenge.R

object CustomBindings {

    @BindingAdapter("setAdapter")
    @JvmStatic
    fun bindRecyclerViewAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
        view.setHasFixedSize(true)
        view.itemAnimator = DefaultItemAnimator()
        view.adapter = adapter
    }

    @BindingAdapter("setOrdersStateBackgroundColor")
    @JvmStatic
    fun bindOrdersStateBackgroundColor(view: View, state: String) {
        when(state){
            "Yolda" ->{
                view.setBackgroundColor(ContextCompat.getColor(view.context, R.color.colorPreparing))
            }
            "Hazırlanıyor"->{
                view.setBackgroundColor(ContextCompat.getColor(view.context, R.color.colorPrimary))
            }
            "Onay Bekliyor"->{
                view.setBackgroundColor(ContextCompat.getColor(view.context, R.color.colorAccent))
            }
        }
    }

    @BindingAdapter("setOrdersStateTextColor")
    @JvmStatic
    fun bindOrdersStateTextColor(view: AppCompatTextView, state: String) {
        when(state){
            "Yolda" ->{
                view.setTextColor(ContextCompat.getColor(view.context, R.color.colorPreparing))
            }
            "Hazırlanıyor"->{
                view.setTextColor(ContextCompat.getColor(view.context, R.color.colorPrimary))
            }
            "Onay Bekliyor"->{
                view.setTextColor(ContextCompat.getColor(view.context, R.color.colorAccent))
            }
        }
    }

    @BindingAdapter("setOrdersDetailVisibility")
    @JvmStatic
    fun bindOrdersDetailVisibility(view: View, visibilityState: Int) {
       if(visibilityState ==0){
           view.visibility = View.GONE
       }else if (visibilityState ==1){
           view.visibility = View.VISIBLE
       }
    }


}