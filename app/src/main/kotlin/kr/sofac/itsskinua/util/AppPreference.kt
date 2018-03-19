package kr.sofac.itsskinua.util

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import android.util.Log
import androidx.content.edit
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kr.sofac.itsskinua.data.model.CartProduct
import kr.sofac.itsskinua.data.model.Category
import kr.sofac.itsskinua.data.model.Product

class AppPreference(context: Context) {

    private var preferences: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
    private val gson: Gson = Gson()

    private val CATEGORIES_KEY: String = "Categories"
    private val CART_KEY: String = "Cart"

    fun getCategories(): List<Category> {
        return gson.fromJson(preferences.getString(CATEGORIES_KEY, "[]"), object : TypeToken<List<Category>>() {}.type)
    }

    fun setCategories(categories: List<Category>) {
        preferences.edit {
            putString(CATEGORIES_KEY, gson.toJson(categories))
        }
    }

    fun getCartProducts(): MutableList<CartProduct> {
        return gson.fromJson(preferences.getString(CART_KEY, "[]"), object : TypeToken<MutableList<CartProduct>>() {}.type)
    }

    fun saveCartProducts(products: MutableList<CartProduct>?) {
        preferences.edit {
            putString(CART_KEY, gson.toJson(products))
        }
    }

    fun addProductToCart(product: Product) {
        var products = getCartProducts()
        if (products.isEmpty()) {
            products = mutableListOf<CartProduct>(CartProduct(product, 1))
            saveCartProducts(products)
            return
        }
        for (cartProduct in products) {
            if (cartProduct.product.url == product.url) {
                cartProduct.amount++
                saveCartProducts(products)
                return
            }
        }
        products.add(CartProduct(product, 1))
        saveCartProducts(products)
    }

    fun removeProductFromCart(product: Product) {
        val products = getCartProducts()
        products.indices
                .filter { products[it].product.url == product.url }
                .forEach { products.removeAt(it) }
        saveCartProducts(products)
    }

    fun saveGoogleCloudKey(key: String) {
        preferences.edit { putString(Constants.GOOGLE_CLOUD_KEY, key) }
    }

    fun getGoogleCloudKey(): String {
        Log.e(Constants.GOOGLE_CLOUD_KEY + " get ", preferences.getString(Constants.GOOGLE_CLOUD_KEY, ""))
        return preferences.getString(Constants.GOOGLE_CLOUD_KEY, "")
    }

}