package kr.sofac.itsskin.ui.detail

import kr.sofac.itsskin.BasePresenter
import kr.sofac.itsskin.BaseView
import kr.sofac.itsskin.data.model.Product

/**
 * Created by Maxim on 2/14/2018.
 */
interface ProductDetailContract {

    interface View: BaseView<Presenter> {
        val isActive: Boolean

        fun showProduct(product: Product)

        fun showToast(toast: String)

        fun hideToast()
    }

    interface Presenter :BasePresenter {
        fun clickBack()
    }


}