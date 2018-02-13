package kr.sofac.itsskin.data.network.dto

class ResponseObject<T>(val responseStatus: String?, val dataTransferObject : T) {
}