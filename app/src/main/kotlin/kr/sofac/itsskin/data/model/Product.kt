package kr.sofac.itsskin.data.model

import com.google.gson.annotations.SerializedName

data class Product(@SerializedName("annotation")
                   var annotation: String? = "",
                   @SerializedName("image")
                   var image: Image?,
                   @SerializedName("featured")
                   var featured: String? = "",
                   @SerializedName("images")
                   var images: List<Image>?,
                   @SerializedName("visible")
                   var visible: String? = "",
                   @SerializedName("meta_title")
                   var metaTitle: String? = "",
                   @SerializedName("created")
                   var created: String? = "",
                   @SerializedName("variants")
                   var variants: List<Variant>,
                   @SerializedName("body")
                   var body: String? = "",
                   @SerializedName("meta_keywords")
                   var metaKeywords: String? = "",
                   @SerializedName("url")
                   var url: String? = "",
                   @SerializedName("related_products")
                   var relatedProducts: List<Product>?,
                   @SerializedName("brand_id")
                   var brandId: String? = "",
                   @SerializedName("meta_description")
                   var metaDescription: String? = "",
                   @SerializedName("features")
                   var features: List<FeaturesItem>?,
                   @SerializedName("name")
                   var name: String? = "",
                   @SerializedName("variant")
                   var variant: Variant?,
                   @SerializedName("id")
                   var id: String? = "",
                   @SerializedName("position")
                   var position: String? = "",
                   @SerializedName("brand")
                   var brand: String? = "")