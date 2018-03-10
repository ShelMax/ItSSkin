package kr.sofac.itsskinapp.data.model

import com.google.gson.annotations.SerializedName

data class Variant(@SerializedName("attachment")
                   var attachment: String = "",
                   @SerializedName("price")
                   var price: String = "",
                   @SerializedName("compare_price")
                   var comparePrice: String = "",
                   @SerializedName("product_id")
                   var productId: Int = 0,
                   @SerializedName("name")
                   var name: String = "",
                   @SerializedName("infinity")
                   var infinity: Int = 0,
                   @SerializedName("id")
                   var id: Int = 0,
                   @SerializedName("position")
                   var position: Int = 0,
                   @SerializedName("sku")
                   var sku: String = "",
                   @SerializedName("stock")
                   var stock: String = "")