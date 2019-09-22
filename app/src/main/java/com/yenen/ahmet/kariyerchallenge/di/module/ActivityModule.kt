package com.yenen.ahmet.kariyerchallenge.di.module

import com.yenen.ahmet.kariyerchallenge.view.LoginActivity
import com.yenen.ahmet.kariyerchallenge.view.OrdersActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Suppress("unused")
@Module

abstract class ActivityModule {

    @ContributesAndroidInjector
    internal abstract fun contributeSearchActivity(): LoginActivity


    @ContributesAndroidInjector
    internal abstract fun contributeOrdersActivity(): OrdersActivity

}