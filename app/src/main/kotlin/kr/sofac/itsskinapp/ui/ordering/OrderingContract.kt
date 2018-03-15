package kr.sofac.itsskinapp.ui.ordering

import kr.sofac.itsskinapp.BasePresenter
import kr.sofac.itsskinapp.BaseView

/**
 * Created by Asus SoFA on 15.03.2018.
 */
interface OrderingContract {

    interface View : BaseView<Presenter> {

        fun showToast(msg: String)
        fun showSnapchat(msg: String)

    }

    interface Presenter : BasePresenter {

        fun orderingProduct()
        fun loadingDelivery()
        fun onDestroy()

    }

}