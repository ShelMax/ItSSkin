package kr.sofac.itsskin.ui.navigation

import kr.sofac.itsskin.data.RequestCallback
import kr.sofac.itsskin.data.model.Category
import kr.sofac.itsskin.data.network.dto.DTO
import kr.sofac.itsskin.data.model.Product
import kr.sofac.itsskin.data.network.RequestManager


class NavigationPresenter(val view : NavigationContract.View) : NavigationContract.Presenter{


    override fun getProducts() {
        RequestManager.getCategories(object : RequestCallback<List<Category>>{
            override fun onSuccess(data: List<Category>) {
                RequestManager.getCategoryProducts(DTO().setCategoryURL(data[0].url!!), object : RequestCallback<List<Product>>{
                    override fun onSuccess(data: List<Product>) {
                        view.onProductsLoaded(data)
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