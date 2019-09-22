package com.yenen.ahmet.kariyerchallenge.binding

import android.annotation.SuppressLint
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
        when (state) {
            "Yolda" -> {
                view.setBackgroundColor(
                    ContextCompat.getColor(
                        view.context,
                        R.color.colorOnTheRoad
                    )
                )
            }
            "Hazırlanıyor" -> {
                view.setBackgroundColor(ContextCompat.getColor(view.context, R.color.colorPreparing))
            }
            "Onay Bekliyor" -> {
                view.setBackgroundColor(ContextCompat.getColor(view.context, R.color.colorAccent))
            }
        }
    }

    @BindingAdapter("setOrdersStateTextColor")
    @JvmStatic
    fun bindOrdersStateTextColor(view: AppCompatTextView, state: String) {
        when (state) {
            "Yolda" -> {
                view.setTextColor(ContextCompat.getColor(view.context, R.color.colorOnTheRoad))
            }
            "Hazırlanıyor" -> {
                view.setTextColor(ContextCompat.getColor(view.context, R.color.colorPreparing))
            }
            "Onay Bekliyor" -> {
                view.setTextColor(ContextCompat.getColor(view.context, R.color.colorAccent))
            }
        }
    }

    @BindingAdapter("setOrdersDetailVisibility")
    @JvmStatic
    fun bindOrdersDetailVisibility(view: View, visibilityState: Int) {
        if (visibilityState == 0) {
            view.visibility = View.GONE
        } else if (visibilityState == 1) {
            view.visibility = View.VISIBLE
        }
    }

    @SuppressLint("SetTextI18n")
    @BindingAdapter("setProductPrice")
    @JvmStatic
    fun bindProductPrice(view: AppCompatTextView, price: Double) {
        view.text = "$price TL"
    }


    @SuppressLint("SetTextI18n")
    @BindingAdapter("setOrdersMonth")
    @JvmStatic
    fun bindOrdersMonth(view: AppCompatTextView, month: String) {
        if (month == "01" || month == "1") {
            view.text = "Ocak"
        } else if (month == "02" || month == "2") {
            view.text = "Şubat"
        } else if (month == "03" || month == "3") {
            view.text = "Mart"
        } else if (month == "04" || month == "4") {
            view.text = "Nisan"
        } else if (month == "05" || month == "5") {
            view.text = "Mayıs"
        } else if (month == "06" || month == "6") {
            view.text = "Haziran"
        } else if (month == "07" || month == "7") {
            view.text = "Temmuz"
        } else if (month == "08" || month == "8") {
            view.text = "Ağustos"
        } else if (month == "09" || month == "9") {
            view.text = "Eylül"
        } else if (month == "10") {
            view.text = "Ekim"
        } else if (month == "11") {
            view.text = "Kasım"
        } else if (month == "12") {
            view.text = "Aralık"
        }

    }

}