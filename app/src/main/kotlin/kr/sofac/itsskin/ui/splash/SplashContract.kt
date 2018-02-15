package kr.sofac.itsskin.ui.splash

import kr.sofac.itsskin.data.model.Category
import kr.sofac.itsskin.ui.base.BaseView

interface SplashContract {

    interface View : BaseView{
        fun onLoaded(categories : List<Category>)
    }

    interface Presenter{
        fun loadCategories()
    }
}