package kr.sofac.itsskinua.ui.splash

import kr.sofac.itsskinua.data.model.Category
import kr.sofac.itsskinua.ui.base.BaseView

interface SplashContract {

    interface View : BaseView{
        fun onLoaded(categories : List<Category>)
        fun startNavigationActivity()
    }

    interface Presenter{
        fun loadCategories()
        fun sendingGoogleCloudKey(key: String)
    }
}