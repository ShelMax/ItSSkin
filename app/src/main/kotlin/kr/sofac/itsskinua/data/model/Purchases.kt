package kr.sofac.itsskinua.data.model

import com.google.gson.annotations.SerializedName

data class Purchases(
        @SerializedName("product")
        var product: Product,
        @SerializedName("variant")
        var variant: Variant,
        @SerializedName("amount")
        var amount: Int)