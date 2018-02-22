package kr.sofac.itsskinapp.ui.detail

import kr.sofac.itsskinapp.data.model.Product
import kr.sofac.itsskinapp.data.model.callback.RequestCallback
import kr.sofac.itsskinapp.data.network.RequestManager
import kr.sofac.itsskinapp.data.network.dto.DTO
import kr.sofac.itsskinapp.util.AppPreference


class ProductDetailPresenter(
        private val view: ProductDetailContract.View) : ProductDetailContract.Presenter {


    override fun loadProduct(productUrl : String) {
        if (productUrl.isEmpty()) {
            view.onLoadError("Not have product for view!")
            return
        }
        RequestManager.getProduct(DTO().setProductURL(productUrl), object : RequestCallback<Product> {
            override fun onSuccess(data: Product) {
                view.onProductLoaded(data)
            }

            override fun onError(message: String) {
                view.onLoadError("Connection error")
            }

        })
    }

}