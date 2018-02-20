package kr.sofac.itsskin.data.model.callback

interface CartCallback {
    fun removeProduct(position : Int)
    fun changeAmount(amount : Int)
}