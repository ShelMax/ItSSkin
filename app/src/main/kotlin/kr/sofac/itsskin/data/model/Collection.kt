package kr.sofac.itsskin.data.model

import com.google.gson.annotations.SerializedName

data class Collection(@SerializedName("meta_description")
                      var metaDescription: String? = "",
                      @SerializedName("image")
                      var image: String? = "",
                      @SerializedName("meta_title")
                      var metaTitle: String? = "",
                      @SerializedName("name")
                      var name: String? = "",
                      @SerializedName("description")
                      var description: String? = "",
                      @SerializedName("id")
                      var id: String? = "",
                      @SerializedName("meta_keywords")
                      var metaKeywords: String? = "",
                      @SerializedName("url")
                      var url: String? = "",
                      @SerializedName("brand_id")
                      var brandId: String? = "")