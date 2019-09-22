package com.yenen.ahmet.kariyerchallenge.dialog

import android.app.Activity
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import com.yenen.ahmet.kariyerchallenge.R

class OrdersSingOutDialog constructor(context: Activity, layoutId: Int, listener: View.OnClickListener) :
    BaseDialog(context, layoutId) {


    init {

        view.findViewById<AppCompatButton>(R.id.dialogCancel)?.let {
            it.setOnClickListener { dismiss() }
        }

        view.findViewById<AppCompatButton>(R.id.dialogSignOut)?.setOnClickListener(listener)
    }


    fun unBind() {
        dismiss()
        view.findViewById<AppCompatButton>(R.id.dialogSignOut)?.setOnClickListener(null)
    }
}