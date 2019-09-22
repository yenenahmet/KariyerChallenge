package com.yenen.ahmet.kariyerchallenge.view

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.yenen.ahmet.kariyerchallenge.R
import com.yenen.ahmet.kariyerchallenge.adapter.listener.OrdersAdapterListener
import com.yenen.ahmet.kariyerchallenge.base.ui.BaseRemoteActivity
import com.yenen.ahmet.kariyerchallenge.databinding.ActivityOrdersBinding
import com.yenen.ahmet.kariyerchallenge.dialog.OrdersSingOutDialog
import com.yenen.ahmet.kariyerchallenge.model.OrdersResponse
import com.yenen.ahmet.kariyerchallenge.viewmodel.OrdersViewModel

class OrdersActivity :
    BaseRemoteActivity<List<OrdersResponse>, OrdersViewModel, ActivityOrdersBinding>(
        OrdersViewModel::class.java,
        true
    ), OrdersAdapterListener, View.OnClickListener {

    override fun onItemClick(item: OrdersResponse, position: Int) {
        if (item.rowDetailVisibility == 0) {
            item.rowDetailVisibility = 1
        } else if (item.rowDetailVisibility == 1) {
            item.rowDetailVisibility = 0
        }
        viewModel.adapter.setChanged(position, item)
    }

    override fun onDataObserve(results: List<OrdersResponse>) {
        viewModel.setItemsAdapter(results)
    }

    override fun onErrorObserve(errorMessage: String) {
        showToast(errorMessage)
    }

    override fun onNoDataFoundObserve(noDataFoundMessage: String) {
        showToast(noDataFoundMessage)
    }

    override fun getLayoutRes(): Int = R.layout.activity_orders

    override fun initViewModel(viewModel: OrdersViewModel) {
        binding.viewModel = viewModel
        viewModel.adapter.setListener(this)
    }


    private var ordersSingOutDialog: OrdersSingOutDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ordersSingOutDialog = OrdersSingOutDialog(this, R.layout.orders_sing_out_dialog, this)
        supportActionBar?.let {
            it.title = "MARKETİM"
            it.setBackgroundDrawable(
                ColorDrawable(
                    ContextCompat.getColor(
                        this,
                        R.color.colorAccent
                    )
                )
            )
        }
    }

    override fun onBindingCreate(binding: ActivityOrdersBinding) {
        binding.signOut.setOnClickListener {
            ordersSingOutDialog?.show()
        }
    }

    override fun onBindingClear(binding: ActivityOrdersBinding) {
        binding.signOut.setOnClickListener(null)
    }

    // Dialog SingOut Click
    override fun onClick(v: View?) {
        viewModel.removeRememberMe()
        val nt = Intent(this, LoginActivity::class.java)
        startActivity(nt)
        finish()
        showToast("Çıkış Yapıldı, Tekrar giriş yapabilirsiniz.")
    }

    override fun onDestroy() {
        super.onDestroy()
        ordersSingOutDialog?.unBind()
        ordersSingOutDialog = null
    }


}
