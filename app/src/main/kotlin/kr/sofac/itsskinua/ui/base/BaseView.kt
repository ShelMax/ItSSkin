package kr.sofac.itsskinua.ui.base

interface BaseView {

    fun setLoading(isLoading : Boolean)
    fun onLoadError(message : String)

}
