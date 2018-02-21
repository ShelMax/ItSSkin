package kr.sofac.itsskinapp.data.network.dto

class ServerRequest<T>(val requestType: String?, val dataTransferObject : T?) {
}