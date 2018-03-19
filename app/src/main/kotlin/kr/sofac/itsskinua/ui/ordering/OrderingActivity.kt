package kr.sofac.itsskinua.ui.ordering

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_ordering.*
import kr.sofac.itsskinua.R
import kr.sofac.itsskinua.data.model.Cart
import kr.sofac.itsskinua.data.model.CheckOut
import kr.sofac.itsskinua.data.model.EmptyResponseContainer
import kr.sofac.itsskinua.data.model.MakeOrder
import kr.sofac.itsskinua.data.model.callback.RequestCallback
import kr.sofac.itsskinua.data.network.RequestManager
import kr.sofac.itsskinua.data.network.dto.DTO
import kr.sofac.itsskinua.ui.navigation.NavigationActivity
import kr.sofac.itsskinua.util.AppPreference

class OrderingActivity : AppCompatActivity() {

    private lateinit var appPreference: AppPreference
    lateinit var mapCart: MutableMap<String, Int>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ordering)
        appPreference = AppPreference(this)
        mapCart = mutableMapOf()

        for (cartProduct in appPreference.getCartProducts()) {
            mapCart[cartProduct.product.variant.id.toString()] = cartProduct.amount
        }
        getCartInformation(mapCart, "")
        initToolbar()
    }

    private fun initToolbar() {
        toolbar.title = getString(R.string.ordering_product)
        setSupportActionBar(toolbar)
        toolbar.setNavigationIcon(R.drawable.arrow_left)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    private fun getCartInformation(shoppingCart: MutableMap<String, Int>, couponCode: String) {
        RequestManager.getCart(DTO().setCartInfo(shoppingCart, couponCode), object : RequestCallback<Cart> {
            override fun onSuccess(data: Cart) {
                hideProgressBar()
                fillDelivery(data)
            }

            override fun onError(message: String) {
                Toast.makeText(applicationContext, getString(R.string.connection_error), Toast.LENGTH_SHORT).show()
                hideProgressBar()
                finish()
            }
        })
    }

    fun fillDelivery(cart: Cart) {
        for (delivery in cart.deliveries) {
            val radioButton = RadioButton(this)
            radioButton.text = delivery.name
            deliveryGroup.addView(radioButton)
        }
        deliveryGroup.check(deliveryGroup.getChildAt(0).id)

        val priceCoupon = cart.totalPrice.toDouble() - (cart.coupon?.toDouble() ?: 0.0)
        val priceDelivery = cart.totalPrice.toDouble() + (cart.deliveries[0].price?.toDouble() ?: 0.0)
        priceWithCoupon.text = priceCoupon.toString()
        priceWithDelivery.text = priceDelivery.toString()

        deliveryGroup.setOnCheckedChangeListener { group, checkedId ->
            Toast.makeText(this, checkedId.toString(), Toast.LENGTH_SHORT).show()
            priceWithDelivery.text = (cart.totalPrice.toDouble() + (cart.deliveries[checkedId-1].price?.toDouble() ?: 0.0)).toString()
        }

        buttonSetOrder.setOnClickListener {
            setOrder(cart.deliveries[deliveryGroup.checkedRadioButtonId].id)
        }
    }

    fun hideProgressBar() {
        progressBarLoadingProduct.visibility = View.GONE
    }

    private fun setOrder(idDeliver: Int) {
        val checkOut = CheckOut(
                idDeliver,
                editTextName.text.toString(),
                editTextEmail.text.toString(),
                editTextPhoneNumber.text.toString(),
                editTextDeliveryAddress.text.toString(),
                editTextComment.text.toString(),
                "")
        val makeOrder: MakeOrder = MakeOrder(mapCart, "", checkOut)
        RequestManager.setOrder(makeOrder, object : RequestCallback<EmptyResponseContainer> {
            override fun onSuccess(data: EmptyResponseContainer) {
                appPreference.saveCartProducts(mutableListOf())
                startNavigationActivity()
                Toast.makeText(applicationContext, "onSuccess", Toast.LENGTH_SHORT).show()
            }

            override fun onError(message: String) {
                Toast.makeText(applicationContext, "onError", Toast.LENGTH_SHORT).show()
            }
        })
    }

    fun startNavigationActivity() {
        startActivity(Intent(this, NavigationActivity::class.java)
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
        finishAffinity()
    }
}
