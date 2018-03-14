package kr.sofac.itsskinapp.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Asus SoFA on 14.03.2018.
 */
data class CheckOut(
        @SerializedName("delivery_id")
        val deliveryId: Int,
        @SerializedName("name")
        val name: String,
        @SerializedName("email")
        val email: String,
        @SerializedName("phone")
        val phone: String,
        @SerializedName("address")
        val address: String,
        @SerializedName("comment")
        val comment: String,
        @SerializedName("ip")
        val ip: String
)