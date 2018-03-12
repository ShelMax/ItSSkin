package kr.sofac.itsskinapp.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Max on 08.03.2018.
 */
data class Delivery(
        @SerializedName("id")
        var id: Int,
        @SerializedName("name")
        var name: String,
        @SerializedName("description")
        var description: String,
        @SerializedName("free_from")
        var freeFrom: String,
        @SerializedName("price")
        var price: String = "0",
        @SerializedName("enabled")
        var enabled: Int,
        @SerializedName("position")
        var position: Int,
        @SerializedName("separate_payment")
        var separatePayment: Int
)