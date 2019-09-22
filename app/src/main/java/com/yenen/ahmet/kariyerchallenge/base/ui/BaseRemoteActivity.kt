package com.yenen.ahmet.kariyerchallenge.base.ui

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.yenen.ahmet.kariyerchallenge.R
import com.yenen.ahmet.kariyerchallenge.base.viewmodel.BaseRxSingleHandlerViewModel
import com.yenen.ahmet.kariyerchallenge.dialog.BaseDialog

// Servisten  bir çağrı yapıp.Geri dönüşü bekledikten sonra,
// eğer data dönerse ekrana basma, boş dönüş olduğunda veya hata olduğunda kullanıcıya bu durumu ifade
// etmek için oluşturulmuştur.
// Amaç: Her seferinde bu işlemlerin tekrarını önlenmek ve  projenin gidiş hattını standartlaştırmak.
// Loading işleminin ve livedata yönetimini doğru bir şekilde sağlamak.
abstract class BaseRemoteActivity<T, VM : BaseRxSingleHandlerViewModel<T>, DB : ViewDataBinding>(
    viewModelClass: Class<VM>, private val isOnCreateGetData: Boolean
) : BaseDaggerActivity<VM, DB>(viewModelClass) {

    private var loadingDialog: BaseDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loadingDialog = BaseDialog(this, R.layout.loading_view)


        if (isOnCreateGetData) {
            runDataObserve(viewModel)
        }
        runErrObserve(viewModel)
        runNoDataFoundObserve(viewModel)

    }

    private fun runErrObserve(viewModel: BaseRxSingleHandlerViewModel<T>) {
        viewModel.errMessage.observe(this, Observer {
            it?.let {
                onErrorObserve(it)
                loadingDialog?.dismiss()
            }
        })
    }

    private fun runNoDataFoundObserve(viewModel: BaseRxSingleHandlerViewModel<T>) {
        viewModel.noDataFound.observe(this, Observer {
            it?.let {
                onNoDataFoundObserve(it)
                loadingDialog?.dismiss()
            }
        })
    }

    protected fun runDataObserve(viewModel: BaseRxSingleHandlerViewModel<T>) {
        preCommunicationProcedures()
        loadingDialog?.show()
        viewModel.getData().observe(this, Observer {
            it?.let {
                onDataObserve(it)
                loadingDialog?.dismiss()
            }
        })
    }

    protected fun runDataChangeable() {
        preCommunicationProcedures()
        loadingDialog?.show()
        viewModel.dataChangeable()
    }

    protected abstract fun onDataObserve(results: T)

    protected abstract fun onErrorObserve(errorMessage: String)

    protected abstract fun onNoDataFoundObserve(noDataFoundMessage: String)

    // Eğer bir çağrı yapamadan önce bir query veya model yollanıyorsa bu fonksiyon overide edilip
    // gerekli veri viewModel üzerinde set edilir //
    // Servic çağrıları herhangi bir parametre içermiyorsa Kullanılmasına gerek yok //
    // Veya sadece bir kerelik viewModel set edilecekse, initViewModel üzerinden bu islem yapılabilir bu fonksiyonu overide etemye gerek  yok//
    protected open fun preCommunicationProcedures() {

    }

    override fun onDestroy() {
        super.onDestroy()
        loadingDialog?.dismiss()
        loadingDialog = null
    }

}