package kr.sofac.itsskin.ui.detail

import kr.sofac.itsskin.BasePresenter
import kr.sofac.itsskin.BaseView
import kr.sofac.itsskin.data.model.Image
import kr.sofac.itsskin.data.model.Product
import kr.sofac.itsskin.util.AppPreference

/**
 * Created by Maxim on 2/14/2018.
 */
interface ProductDetailContract {

    interface View : BaseView<Presenter> {
        val isActive: Boolean

        fun fillProductDescription(product: Product)

        fun showSimilarProductScroller(listProduct: List<Product>)

        fun hideSimilarProductScroller()

        fun showImageScroller(images: List<Image>)

        fun showToast(toast: String)

        fun showComments()

    }

    interface Presenter : BasePresenter {

        fun addProductToShopCart(appPreference: AppPreference)

        fun clickShowReview()

    }


}