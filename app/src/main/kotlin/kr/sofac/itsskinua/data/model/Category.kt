package kr.sofac.itsskinua.data.model

import com.google.gson.annotations.SerializedName

data class Category(var image: String? = "",
                    var visible: Int? = 0,
                    @SerializedName("meta_title")
                    var metaTitle: String? = "",
                    var level: Int? = 0,
                    var description: String? = "",
                    @SerializedName("meta_keywords")
                    var metaKeywords: String? = "",
                    var url: String? = "",
                    @SerializedName("meta_description")
                    var metaDescription: String? = "",
                    @SerializedName("parent_id")
                    var parentId: Int? = 0,
                    var name: String? = "",
                    var id: Int? = 0,
                    var position: Int? = 0,
                    var subcategories: List<Category>?)