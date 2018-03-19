package kr.sofac.itsskinua.data.model.callback

interface CartCallback {
    fun removeProduct(position : Int)
    fun amountChanged()
}