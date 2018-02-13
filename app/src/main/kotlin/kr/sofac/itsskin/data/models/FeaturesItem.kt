package kr.sofac.itsskin.data.models

import com.google.gson.annotations.SerializedName

data class FeaturesItem(@SerializedName("feature_id")
                        var featureId: Int? = 0,
                        @SerializedName("product_id")
                        var productId: Int? = 0,
                        @SerializedName("name")
                        var name: String? = "",
                        @SerializedName("value")
                        var value: String? = "")