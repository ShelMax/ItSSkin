package kr.sofac.itsskinapp.data.model.callback

interface CartCallback {
    fun removeProduct(position : Int)
    fun amountChanged()
}