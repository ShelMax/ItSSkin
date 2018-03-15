package kr.sofac.itsskinapp.ui.splash

import kr.sofac.itsskinapp.data.model.Category
import kr.sofac.itsskinapp.ui.base.BaseView

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