package kr.sofac.itsskin.ui.detail

import kr.sofac.itsskin.BasePresenter
import kr.sofac.itsskin.BaseView
import kr.sofac.itsskin.data.model.Image
import kr.sofac.itsskin.data.model.Product

/**
 * Created by Maxim on 2/14/2018.
 */
interface ProductDetailContract {

    interface View : BaseView<Presenter> {
        val isActive: Boolean

        fun showProductDescription(product: Product)

        fun showSameProductScroller(listProduct: List<Product>)

        fun showImageScroller(adapter: ImageScrollerAdapter)

        fun showToast(toast: String)

        fun showComments()

        fun showLoadingIndicator()

        fun hideLoadingIndicator()

    }

    interface Presenter : BasePresenter {

        fun addProductToShopCart()

        fun clickShowReview()

    }


}