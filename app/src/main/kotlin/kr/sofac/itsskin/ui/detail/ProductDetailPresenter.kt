package kr.sofac.itsskin.ui.detail

import kr.sofac.itsskin.data.model.Product
import kr.sofac.itsskin.data.model.callback.RequestCallback
import kr.sofac.itsskin.data.network.RequestManager
import kr.sofac.itsskin.data.network.dto.DTO

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

    override fun start() {
        openProduct()
    }

    fun openProduct(){
        if(productUrl.isEmpty()){
            productDetailView.showToast("Not have product for view!")
            return
        }
        productDetailView.showLoadingIndicator()
         RequestManager.getProduct(DTO().setProductURL(productUrl), object : RequestCallback<Product> {
            override fun onSuccess(data: Product) {
                productDetailView.showImageScroller(ImageScrollerAdapter(data.images?: listOf()))
            }

            override fun onError(message: String) {

            }

        })
    }

    override fun addProductToShopCart(){

    }

    override fun clickShowReview(){

    }

}