package kr.sofac.itsskinapp.data.network.dto

class ResponseObject<T>(val responseStatus: String?, val dataTransferObject : T) {
}