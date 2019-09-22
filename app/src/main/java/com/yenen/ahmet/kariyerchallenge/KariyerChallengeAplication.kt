package com.yenen.ahmet.kariyerchallenge

import com.yenen.ahmet.kariyerchallenge.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class KariyerChallengeAplication :DaggerApplication() {

    private val appComponent = DaggerAppComponent.builder()
        .application(this)
        .build()


    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return appComponent
    }


}