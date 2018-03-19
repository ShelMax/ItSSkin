package kr.sofac.itsskinua.data.model

import com.google.gson.annotations.SerializedName

data class Image(@SerializedName("filename")
                 var filename: String? = "",
                 @SerializedName("product_id")
                 var productId: Int? = 0,
                 @SerializedName("name")
                 var name: String? = "",
                 @SerializedName("id")
                 var id: Int? = 0,
                 @SerializedName("position")
                 var position: Int? = 0)