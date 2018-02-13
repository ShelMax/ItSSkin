package kr.sofac.itsskin.data.models

import com.google.gson.annotations.SerializedName

data class Category(@SerializedName("image")
                    var image: String? = "",
                    @SerializedName("visible")
                    var visible: Int? = 0,
                    @SerializedName("meta_title")
                    var metaTitle: String? = "",
                    @SerializedName("level")
                    var level: Int? = 0,
                    @SerializedName("description")
                    var description: String? = "",
                    @SerializedName("meta_keywords")
                    var metaKeywords: String? = "",
                    @SerializedName("url")
                    var url: String? = "",
                    @SerializedName("meta_description")
                    var metaDescription: String? = "",
                    @SerializedName("parent_id")
                    var parentId: Int? = 0,
                    @SerializedName("name")
                    var name: String? = "",
                    @SerializedName("id")
                    var id: Int? = 0,
                    @SerializedName("position")
                    var position: Int? = 0,
                    @SerializedName("subcategories")
                    var subcategories: List<Category>?)