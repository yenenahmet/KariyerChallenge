package com.yenen.ahmet.kariyerchallenge.di.module

import com.google.gson.GsonBuilder
import com.yenen.ahmet.kariyerchallenge.BuildConfig
import com.yenen.ahmet.kariyerchallenge.remote.KariyerChallengeService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClientBuilder(): OkHttpClient.Builder {
        val okHttpClientBuilder = OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)

        if (BuildConfig.DEBUG) {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            return okHttpClientBuilder.addInterceptor(interceptor)
        } else {
            return okHttpClientBuilder
        }
    }


    @Provides
    @Singleton
    fun provideKariyerChallengeService(okHttpClientBuilder: OkHttpClient.Builder): KariyerChallengeService {
        val okHttpClient = okHttpClientBuilder.build()
        val retrofit = Retrofit.Builder()
            .baseUrl("http://kariyertechchallenge.mockable.io")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient).build()
        return retrofit.create(KariyerChallengeService::class.java)
    }


}