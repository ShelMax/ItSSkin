package kr.sofac.itsskinapp.ui.base

interface BaseView {

    fun setLoading(isLoading : Boolean)
    fun onLoadError(message : String)
}