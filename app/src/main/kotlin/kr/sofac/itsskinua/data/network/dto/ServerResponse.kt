package kr.sofac.itsskinua.data.network.dto

class ServerResponse<out T>(val responseStatus: String?, val dataTransferObject : T)