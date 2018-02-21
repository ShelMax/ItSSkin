package kr.sofac.itsskinapp.ui.detail

import kr.sofac.itsskinapp.BasePresenter
import kr.sofac.itsskinapp.BaseView
import kr.sofac.itsskinapp.data.model.Image
import kr.sofac.itsskinapp.data.model.Product
import kr.sofac.itsskinapp.util.AppPreference

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

        fun hideLoadingIndicator()

    }

    interface Presenter : BasePresenter {

        fun addProductToShopCart(appPreference: AppPreference)

        fun clickShowReview()

    }


}