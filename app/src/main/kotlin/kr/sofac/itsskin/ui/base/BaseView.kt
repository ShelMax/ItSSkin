package kr.sofac.itsskin.ui.base

interface BaseView {

    fun setLoading(isLoading : Boolean)
    fun onLoadError(message : String)
}