package kr.sofac.itsskin.ui.splash

import kr.sofac.itsskin.data.model.Category
import kr.sofac.itsskin.data.model.callback.RequestCallback
import kr.sofac.itsskin.data.network.RequestManager
import java.util.*


class SplashPresenter(private val view : SplashContract.View) : SplashContract.Presenter {

    override fun loadCategories() {
        view.setLoading(true)
        RequestManager.getCategories(object : RequestCallback<List<Category>>{
            override fun onSuccess(data: List<Category>) {
                view.onLoaded(data)
                view.setLoading(false)
            }

            override fun onError(message: String) {
                view.onLoadError(message)
                view.setLoading(false)
            }
        })
    }
}