package com.yenen.ahmet.kariyerchallenge.di.module

import android.content.Context
import com.yenen.ahmet.kariyerchallenge.local.SharedPreferencesHelper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalModule {

    @Provides
    @Singleton
    fun provideSharedPreferencesHelper(context: Context): SharedPreferencesHelper {
        return SharedPreferencesHelper(context)
    }


}