package com.yenen.ahmet.kariyerchallenge.view

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import com.yenen.ahmet.kariyerchallenge.R
import com.yenen.ahmet.kariyerchallenge.base.ui.BaseDaggerActivity
import com.yenen.ahmet.kariyerchallenge.databinding.ActivityLoginBinding
import com.yenen.ahmet.kariyerchallenge.dialog.BaseDialog
import com.yenen.ahmet.kariyerchallenge.viewmodel.LoginViewModel

class LoginActivity :
    BaseDaggerActivity<LoginViewModel, ActivityLoginBinding>(LoginViewModel::class.java) {

    override fun getLayoutRes(): Int = R.layout.activity_login

    override fun initViewModel(viewModel: LoginViewModel) {
        binding.viewModel = viewModel
    }

    private var loadingDialog: BaseDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadingDialog = BaseDialog(this, R.layout.loading_view)

        if (viewModel.isLogin()) {
            val nt = Intent(this, OrdersActivity::class.java)
            startActivity(nt)
            finish()
            return
        }
        loginObserve()
    }

    override fun onBindingCreate(binding: ActivityLoginBinding) {
        binding.btnLogin.setOnClickListener {
            loadingDialog?.show()
            viewModel.login()
        }
    }

    private fun loginObserve() {
        viewModel.loginResult.observe(this, Observer {
            loadingDialog?.dismiss()
            it?.let {
                if (it == "Giriş Başarılı") {
                    val nt = Intent(this, OrdersActivity::class.java)
                    startActivity(nt)
                    finish()
                } else {
                    showToast(it)
                }
            }
        })
    }


    override fun onBindingClear(binding: ActivityLoginBinding) {
        binding.btnLogin.setOnClickListener(null)
    }

    override fun onDestroy() {
        super.onDestroy()
        loadingDialog?.dismiss()
        loadingDialog = null
    }

}
