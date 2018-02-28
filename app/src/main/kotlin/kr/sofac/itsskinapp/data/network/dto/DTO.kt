package kr.sofac.itsskinapp.data.network.dto

import com.google.gson.annotations.SerializedName

class DTO {

    @SerializedName("category_url")
    private lateinit var categoryURL : String

    @SerializedName("product_url")
    private lateinit var productURL : String

    @SerializedName("shopping_cart")
    private lateinit var shoppingCart : Map<String, Int>

    @SerializedName("coupon_code")
    private lateinit var couponCode : String





    fun setCategoryURL(categoryURL : String) : DTO {
        this.categoryURL = categoryURL
        return this
    }

    fun setProductURL(productURL : String) : DTO {
        this.productURL = productURL
        return this
    }

    fun setCartInfo(shoppingCart : MutableMap<String, Int>, couponCode : String) : DTO {
        this.shoppingCart = shoppingCart
        this.couponCode = couponCode
        return this
    }

}