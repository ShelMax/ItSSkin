package kr.sofac.itsskinapp.data.model

import com.google.gson.annotations.SerializedName

data class Cart(
        @SerializedName("purchases")
        var purchases: MutableMap<String, Purchases>,
        @SerializedName("total_price")
        var totalPrice: Int,
        @SerializedName("total_products")
        var totalProducts: Int,
        @SerializedName("coupon")
        var coupon: String? = "0",
        @SerializedName("deliveries")
        var deliveries: MutableList<Delivery>)