package kr.sofac.itsskin.data.network.dto

/**
 * Created by Maxim on 2/13/2018.
 */
class ResponseObject<T>(val responseStatus: String?, dataTransferObject : T) {
}