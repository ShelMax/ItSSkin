package kr.sofac.itsskinua.ui.navigation

import kr.sofac.itsskinua.data.model.Product

interface NavigationGridContract {

    interface View {
        fun onProductsLoaded(products: MutableList<Product>)
        fun onLoadError(message: String)
        fun startDetailProductActivity(productURL: String?)
    }

    interface Presenter {
        fun loadDefaultProducts()
        fun loadCategoryProducts(categoryURL: String)
        fun onItemClick(productUrl: String?)
    }
}