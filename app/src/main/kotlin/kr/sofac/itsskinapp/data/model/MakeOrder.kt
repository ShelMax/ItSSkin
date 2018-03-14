package kr.sofac.itsskinapp.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Asus SoFA on 14.03.2018.
 */
data class MakeOrder(
        @SerializedName("shopping_cart")
        val shoppingCart: MutableMap<String, Int>,
        @SerializedName("coupon_code")
        val coupon_code: String,
        @SerializedName("checkout")
        val checkout: CheckOut
)