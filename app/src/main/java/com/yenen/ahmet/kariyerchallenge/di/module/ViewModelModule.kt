package com.yenen.ahmet.kariyerchallenge.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.yenen.ahmet.kariyerchallenge.di.factory.AppViewModelFactory
import com.yenen.ahmet.kariyerchallenge.di.scope.ViewModelKey
import com.yenen.ahmet.kariyerchallenge.viewmodel.LoginViewModel
import com.yenen.ahmet.kariyerchallenge.viewmodel.OrdersViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
internal abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    internal abstract fun bindLoginViewModel(viewModel: LoginViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(OrdersViewModel::class)
    internal abstract fun bindOrdersViewModel(viewModel: OrdersViewModel): ViewModel


    @Binds
    internal abstract fun bindViewModelFactory(appViewModelFactory: AppViewModelFactory): ViewModelProvider.Factory

}