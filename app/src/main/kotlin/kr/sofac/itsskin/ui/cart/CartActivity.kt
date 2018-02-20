package kr.sofac.itsskin.ui.cart

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_cart.*
import kr.sofac.itsskin.R
import kr.sofac.itsskin.data.model.CartProduct
import kr.sofac.itsskin.data.model.Product
import kr.sofac.itsskin.data.model.callback.CartCallback
import kr.sofac.itsskin.util.AppPreference

class CartActivity : AppCompatActivity() {

    //TODO при изменении количества продуктов в корзине заносить новое количество в префы

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
        })
        cartRecycler.layoutManager = LinearLayoutManager(this)

    }

    private fun initToolbar() {
        toolbar.title = "Корзина"
        setSupportActionBar(toolbar)
        toolbar.setNavigationIcon(R.drawable.arrow_left)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}
