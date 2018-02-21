package kr.sofac.itsskinapp.util

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import androidx.content.edit
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kr.sofac.itsskinapp.data.model.CartProduct
import kr.sofac.itsskinapp.data.model.Category
import kr.sofac.itsskinapp.data.model.Product

class AppPreference (context: Context){

    private var preferences: SharedPreferences
    private val gson : Gson = Gson()

    private val CATEGORIES_KEY : String = "Categories"
    private val CART_KEY : String = "Cart"

    init {
        preferences = PreferenceManager.getDefaultSharedPreferences(context)
    }

    fun getCategories() : List<Category>{
        return gson.fromJson(preferences.getString(CATEGORIES_KEY,""), object: TypeToken<List<Category>>() {}.type)
    }

    fun setCategories(categories : List<Category>){
        preferences.edit {
            putString(CATEGORIES_KEY, gson.toJson(categories))
        }
    }

    fun getCartProducts() : MutableList<CartProduct>{
        return gson.fromJson(preferences.getString(CART_KEY, "[]"), object : TypeToken<MutableList<CartProduct>>() {}.type)
    }

    private fun saveCartProducts(products : MutableList<CartProduct>?){
        preferences.edit {
            putString(CART_KEY, gson.toJson(products))
        }
    }

    fun addProductToCart(product: Product){
        var products = getCartProducts()
        if (products.isEmpty()) {
            products = mutableListOf<CartProduct>(CartProduct(product, 1))
            saveCartProducts(products)
            return
        }
        for (cartProduct in products){
            if (cartProduct.product.url == product.url){
                cartProduct.amount++;
                saveCartProducts(products)
                return
            }
        }
        products.add(CartProduct(product,1))
        saveCartProducts(products)
    }

    fun removeProductFromCart(product: Product){
        val products = getCartProducts()
        products.indices
                .filter { products[it].product.url == product.url }
                .forEach { products.removeAt(it) }
        saveCartProducts(products)
    }

}