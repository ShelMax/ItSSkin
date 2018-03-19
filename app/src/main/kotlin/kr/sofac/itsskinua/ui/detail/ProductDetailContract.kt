package kr.sofac.itsskinua.ui.detail

import kr.sofac.itsskinua.BasePresenter
import kr.sofac.itsskinua.data.model.Product
import kr.sofac.itsskinua.BaseView
import kr.sofac.itsskinua.data.model.Image
import kr.sofac.itsskinua.data.model.ProductDetail

interface ProductDetailContract {

    interface View : BaseView<Presenter> {

        var isActive: Boolean

        fun showImageViewPager(images: List<Image>)

        fun fillProductDescription(product: ProductDetail)

        fun showSimilarProductScroller(listProduct: List<Product>)

        fun hideSimilarProductScroller()

        fun showCommentsView()

        fun showToastMessage(toastMessage: String)

        fun showMessageInSnackBar()

        fun showLoadingProgressBar()

        fun hideLoadingProgressBar()



    }

    interface Presenter : BasePresenter {

        fun openProduct()

        fun performAddToCart()

        fun performOpenComment()

    }


}