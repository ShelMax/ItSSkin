package kr.sofac.itsskinua.ui.ordering

import kr.sofac.itsskinua.BasePresenter
import kr.sofac.itsskinua.BaseView

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