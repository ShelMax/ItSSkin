package kr.sofac.itsskin.data

interface RequestCallback<T> {
    fun onSuccess(data : T)
    fun onError(message : String)
}