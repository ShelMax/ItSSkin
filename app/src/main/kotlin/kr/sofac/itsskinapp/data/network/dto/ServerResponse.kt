package kr.sofac.itsskinapp.data.network.dto

class ServerResponse<out T>(val responseStatus: String?, val dataTransferObject : T)