package kr.sofac.itsskin.ui.navigation

import kr.sofac.itsskin.data.model.callback.RequestCallback
import kr.sofac.itsskin.data.model.Category
import kr.sofac.itsskin.data.network.dto.DTO
import kr.sofac.itsskin.data.model.Product
import kr.sofac.itsskin.data.network.RequestManager


class NavigationGridPresenter(val view : NavigationGridContract.View) : NavigationGridContract.Presenter{


    override fun loadProducts() {
        RequestManager.getCategories(object : RequestCallback<List<Category>> {
            override fun onSuccess(data: List<Category>) {
                RequestManager.getCategoryProducts(DTO().setCategoryURL(data[0].url!!), object : RequestCallback<List<Product>> {
                    override fun onSuccess(data: List<Product>) {
                        view.onProductsLoaded(data.toMutableList())
                    }

                    override fun onError(message: String) {
                        view.onLoadError(message)
                    }
                })
            }

            override fun onError(message: String) {
                view.onLoadError(message)
            }
        })
    }

}