package com.yenen.ahmet.kariyerchallenge.viewmodel

import androidx.lifecycle.MutableLiveData
import com.yenen.ahmet.kariyerchallenge.base.viewmodel.BaseViewModel
import com.yenen.ahmet.kariyerchallenge.local.SharedPreferencesHelper
import javax.inject.Inject

class LoginViewModel @Inject constructor(private val sharedPreferencesHelper: SharedPreferencesHelper) :
    BaseViewModel() {

    val userName by lazy {
        MutableLiveData<String>()
    }
    val userPassword by lazy {
        MutableLiveData<String>()
    }
    val rememberMe by lazy {
        MutableLiveData<Boolean>()
    }
    val loginResult by lazy {
        MutableLiveData<String>()
    }

    fun login() {

        if (userName.value == null || userPassword.value == null) {
            loginResult.value = "Kullanıcı Adı ve Şifreyi Boş Bırakamazsınız !"
            return
        }
        if (userName.value!!.isEmpty() || userPassword.value!!.isEmpty()) {
            loginResult.value = "Kullanıcı Adı ve Şifreyi Boş Bırakamazsınız !"
            return
        }

        if (userName.value != "kariyer" || userPassword.value != "2019ADev") {
            loginResult.value = "Kullanıcı Adı veya Şifre Yanlış !"
            return
        }

        val rememberMeValue: Boolean = if (rememberMe.value == null) false else rememberMe.value!!
        sharedPreferencesHelper.addRememberMe(rememberMeValue)

        loginResult.value = "Giriş Başarılı"
    }


    fun isLogin(): Boolean {
        return sharedPreferencesHelper.getRememberMe()
    }

}