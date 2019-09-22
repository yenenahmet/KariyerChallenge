package com.yenen.ahmet.kariyerchallenge.local

import android.annotation.SuppressLint
import android.content.Context

@SuppressLint("CommitPrefEdits")
class SharedPreferencesHelper constructor(context: Context) {

    private val sharedPref = context.getSharedPreferences("kariyer", Context.MODE_PRIVATE)
    private val editor = sharedPref.edit()


    // Add
    fun addRememberMe(status: Boolean) {
        editor.putBoolean("rememberMe", status)
        editor.apply()
    }

    // Add

    // Get //

    fun getRememberMe(): Boolean {
        return sharedPref.getBoolean("rememberMe", false)
    }
    // Get //


    //remove//
    fun removeRememberMe() {
        editor.remove("rememberMe")
        editor.apply()
    }
    //remove//

}