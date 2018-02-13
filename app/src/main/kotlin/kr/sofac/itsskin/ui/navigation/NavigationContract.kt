package kr.sofac.itsskin.ui.navigation

import kr.sofac.itsskin.data.model.Product

interface NavigationContract {

    interface View{
        fun onProductsLoaded(products : List<Product>)
        fun onLoadError(message : String)
    }

    interface Presenter{
        fun getProducts()
    }
}