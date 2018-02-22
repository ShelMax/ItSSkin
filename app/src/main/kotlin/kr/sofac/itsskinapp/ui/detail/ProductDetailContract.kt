package kr.sofac.itsskinapp.ui.detail

import kr.sofac.itsskinapp.data.model.Image
import kr.sofac.itsskinapp.data.model.Product
import kr.sofac.itsskinapp.ui.base.BaseView
import kr.sofac.itsskinapp.util.AppPreference

interface ProductDetailContract {

    interface View : BaseView{

        fun onProductLoaded(product: Product)

        fun showComments()

    }

    interface Presenter {

        fun loadProduct(productUrl : String)

    }


}