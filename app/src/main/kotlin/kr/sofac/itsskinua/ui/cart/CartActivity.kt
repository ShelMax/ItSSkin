package kr.sofac.itsskinua.ui.cart

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.activity_cart.*
import kr.sofac.itsskinua.R
import kr.sofac.itsskinua.data.model.CartProduct
import kr.sofac.itsskinua.data.model.callback.CartCallback
import kr.sofac.itsskinua.ui.navigation.NavigationActivity
import kr.sofac.itsskinua.ui.ordering.OrderingActivity
import kr.sofac.itsskinua.util.AppPreference

class CartActivity : AppCompatActivity() {

    private lateinit var products: MutableList<CartProduct>
    private lateinit var appPreference: AppPreference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
        initToolbar()
        appPreference = AppPreference(this)
        products = appPreference.getCartProducts()
        if (products.isEmpty()) {
            initEmptyCart()
        } else {
            initCart()
        }
        checkout.setOnClickListener { startActivity(Intent(this, OrderingActivity::class.java)) }

    }

    private fun initCart() {
        emptyCartConstraint.visibility = View.GONE
        cartRecycler.adapter = CartAdapter(products, object : CartCallback {
            override fun removeProduct(position: Int) {
                appPreference.removeProductFromCart(products[position].product)
                products.removeAt(position)
                if (products.isEmpty())
                    initEmptyCart()
            }

            override fun amountChanged() {
                updateTotalPrice()
            }
        })
        cartRecycler.layoutManager = LinearLayoutManager(this)
        updateTotalPrice()
    }

    private fun initEmptyCart() {
        cartConstraint.visibility = View.GONE
        emptyCartConstraint.visibility = View.VISIBLE
        backToShop.setOnClickListener {
            startActivity(Intent(this, NavigationActivity::class.java))
            finishAffinity()
        }
    }

    private fun updateTotalPrice() {
        var totalPrice = 0.0
        products.forEach {
            totalPrice += it.product.variant?.price!!.toDouble() * it.amount
        }
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
