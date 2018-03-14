package kr.sofac.itsskinapp.ui.detail

import kr.sofac.itsskinapp.BasePresenter
import kr.sofac.itsskinapp.data.model.Product
import kr.sofac.itsskinapp.BaseView
import kr.sofac.itsskinapp.data.model.Image
import kr.sofac.itsskinapp.data.model.ProductDetail

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