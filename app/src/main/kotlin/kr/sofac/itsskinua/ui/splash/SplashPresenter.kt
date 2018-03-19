package kr.sofac.itsskinua.ui.splash

import android.util.Log
import kr.sofac.itsskinua.data.model.Category
import kr.sofac.itsskinua.data.model.callback.RequestCallback
import kr.sofac.itsskinua.data.network.RequestManager


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

    override fun sendingGoogleCloudKey(key: String) {
        RequestManager.setGoogleKey(key, object : RequestCallback<String>{
            override fun onSuccess(data: String) {
                Log.e("onSuccess - GKey", data)
            }

            override fun onError(message: String) {
                Log.e("onError - GKey", message)
            }
        })
    }
}