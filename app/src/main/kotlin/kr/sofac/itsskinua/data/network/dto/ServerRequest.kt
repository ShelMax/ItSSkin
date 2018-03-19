package kr.sofac.itsskinua.data.network.dto

class ServerRequest<T>(val requestType: String?, val dataTransferObject : T?) {
}