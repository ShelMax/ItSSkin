package kr.sofac.itsskin.ui.navigation

import kr.sofac.itsskin.data.model.Product

interface NavigationGridContract {

    interface View {
        fun onProductsLoaded(products: MutableList<Product>)
        fun onLoadError(message: String)
        fun onShowToast(message: String)
        fun startDetailProductActivity(productId: String?)
    }

    interface Presenter {
        fun loadDefaultProducts()
        fun loadCategoryProducts(categoryURL: String)
        fun onItemClick(productUrl: String?)
    }
}