package kr.sofac.itsskinapp.ui.detail

import kr.sofac.itsskinapp.data.model.Product
import kr.sofac.itsskinapp.data.model.callback.RequestCallback
import kr.sofac.itsskinapp.data.network.RequestManager
import kr.sofac.itsskinapp.data.network.dto.DTO


class ProductDetailPresenter(
        private val productUrl: String,
        private val view: ProductDetailContract.View) : ProductDetailContract.Presenter {

    init {
        view.presenter = this
    }

    override fun start() {
        openProduct()
    }


    override fun openProduct() {
        view.showLoadingProgressBar()
        if (productUrl.isEmpty()) {
            view.showToastMessage("Not have product for view!")
            return
        }
        RequestManager.getProduct(DTO().setProductURL(productUrl), object : RequestCallback<Product> {
            override fun onSuccess(data: Product) {
                view.showImageViewPager(data.images ?: listOf())
                view.fillProductDescription(data)
                if (data.relatedProducts != null)
                view.showSimilarProductScroller(data.relatedProducts as List<Product>)
                else view.hideSimilarProductScroller()

            }

            override fun onError(message: String) {
                view.showToastMessage("Connection error")
            }

        })
        view.hideLoadingProgressBar()
    }

    override fun performAddToCart() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun performOpenComment() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}