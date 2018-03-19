package kr.sofac.itsskinua.data.model.callback

interface RequestCallback<T> {
    fun onSuccess(data : T)
    fun onError(message : String)
}