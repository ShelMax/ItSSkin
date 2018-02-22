package kr.sofac.itsskinapp.ui.cart

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_cart.*
import kr.sofac.itsskinapp.R
import kr.sofac.itsskinapp.data.model.CartProduct
import kr.sofac.itsskinapp.data.model.callback.CartCallback
import kr.sofac.itsskinapp.util.AppPreference

class CartActivity : AppCompatActivity() {

    private lateinit var products : MutableList<CartProduct>
    private lateinit var appPreference: AppPreference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
        initToolbar()
        appPreference = AppPreference(this)
        products = appPreference.getCartProducts()
        cartRecycler.adapter = CartAdapter(products, object : CartCallback {
            override fun removeProduct(position: Int) {
                appPreference.removeProductFromCart(products[position].product)
                products.removeAt(position)
            }

            override fun amountChanged() {
                updateTotalPrice()
            }
        })
        cartRecycler.layoutManager = LinearLayoutManager(this)
        updateTotalPrice()
    }

    private fun updateTotalPrice() {
        var totalPrice = 0.0
        products.forEach {
            totalPrice += it.product.variant?.price!!.toDouble() * it.amount }
        productsSum.text = totalPrice.toString()
    }

    private fun initToolbar() {
        toolbar.title = "Корзина"
        setSupportActionBar(toolbar)
        toolbar.setNavigationIcon(R.drawable.arrow_left)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    override fun onStop() {
        appPreference.saveCartProducts(products)
        super.onStop()
    }
}
