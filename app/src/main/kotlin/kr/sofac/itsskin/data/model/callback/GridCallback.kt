package kr.sofac.itsskin.data.model.callback

interface GridCallback {
    fun itemClick(position: Int)
    fun addToCartClick(position: Int)
}