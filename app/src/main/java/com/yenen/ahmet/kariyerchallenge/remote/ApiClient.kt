package com.yenen.ahmet.kariyerchallenge.remote

import android.util.Log
import com.google.gson.JsonSyntaxException
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException

class ApiClient {

    companion object {
        // Error Handler Message // gelen hata mesajına göre handler edilip geriye ona göre mesaj yollanabilir !
        fun failMessage(t: Throwable): String {
            Log.e("ApiClientFailMessage", t.toString())
            when (t) {
                is HttpException -> {
                    val response = t.response()
                    Log.e("Response Code =", response.code().toString())
                    //   if (response.code() == 401) {
                    //     return "401 AUT Yetk sorunu"
                    //}
                    return "Bağlantı Kurulamadı"
                }
                is SocketTimeoutException -> return "Bağlantı zaman aşımına uğradı"
                is IOException -> return "İnternet bağlantınızda sorun var vağlantı kurulamadı"
                is JsonSyntaxException -> return "Yapısal bir sorun oluştu"
                else -> return "Veriler alınırken hata olutu !"
            }
        }
    }
}