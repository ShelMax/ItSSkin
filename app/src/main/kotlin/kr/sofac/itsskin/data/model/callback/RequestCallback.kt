package kr.sofac.itsskin.data.model.callback

interface RequestCallback<T> {
    fun onSuccess(data : T)
    fun onError(message : String)
}