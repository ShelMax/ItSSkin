package kr.sofac.itsskinapp.ui.detail

import kr.sofac.itsskinapp.data.model.Product
import kr.sofac.itsskinapp.data.model.callback.RequestCallback
import kr.sofac.itsskinapp.data.network.RequestManager
import kr.sofac.itsskinapp.data.network.dto.DTO
import kr.sofac.itsskinapp.util.AppPreference

/**
 * Created by Maxim on 2/14/2018.
 */

class ProductDetailPresenter(
        private val productUrl: String,
        private val productDetailView: ProductDetailContract.View
) : ProductDetailContract.Presenter {

    init {
        productDetailView.presenter = this
    }

    lateinit var product: Product

    override fun start() {
        openProduct()
    }

    private fun openProduct() {
        if (productUrl.isEmpty()) {
            productDetailView.showToast("Not have product for view!")
            return
        }
        RequestManager.getProduct(DTO().setProductURL(productUrl), object : RequestCallback<Product> {
            override fun onSuccess(data: Product) {
                product = data
                productDetailView.showImageScroller(data.images ?: listOf())
                productDetailView.fillProductDescription(data)
                if (data.relatedProducts == null || data.relatedProducts!!.isEmpty())
                    productDetailView.hideSimilarProductScroller()
                else
                    productDetailView.showSimilarProductScroller(data.relatedProducts ?: listOf())
                productDetailView.hideLoadingIndicator()
            }

            override fun onError(message: String) {
                productDetailView.showToast("Connection error")
            }

        })
    }

    override fun addProductToShopCart(appPreference: AppPreference) {
        appPreference.addProductToCart(product)
    }

    override fun clickShowReview() {

    }

}