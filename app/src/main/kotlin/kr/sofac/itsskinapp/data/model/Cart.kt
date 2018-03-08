package kr.sofac.itsskinapp.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Asus SoFA on 08.03.2018.
 */
data class Cart(
        @SerializedName("purchases")
        var purchases: MutableList<Any>,
        @SerializedName("total_price")
        var totalPrice: Int,
        @SerializedName("total_products")
        var totalProducts: Int,
        @SerializedName("coupon")
        var coupon: String,
        @SerializedName("deliveries")
        var deliveries: MutableList<Any>) {
}