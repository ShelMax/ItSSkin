package kr.sofac.itsskinapp.data.model.callback

interface GridCallback {
    fun itemClick(position: Int)
    fun addToCartClick(position: Int)
}