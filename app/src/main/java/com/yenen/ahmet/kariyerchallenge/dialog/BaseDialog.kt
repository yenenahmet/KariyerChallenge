package com.yenen.ahmet.kariyerchallenge.dialog

import android.app.Activity
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.yenen.ahmet.kariyerchallenge.R

open class BaseDialog(protected val context: Activity, layutId: Int) {

    protected val dialog: AlertDialog
    protected val view: View = context.layoutInflater.inflate(layutId, null)

    init {
        dialog = AlertDialog.Builder(context).setView(view).setCancelable(false).create()
        val color = ColorDrawable(Color.TRANSPARENT)
        dialog.window?.let {
            it.attributes.windowAnimations = R.style.DialogScale
            it.setBackgroundDrawable(color)
        }

    }


    fun show() {
        context.runOnUiThread {
            dialog.show()
        }
    }

    fun dismiss() {
        context.runOnUiThread {
            dialog.dismiss()
        }
    }


}
