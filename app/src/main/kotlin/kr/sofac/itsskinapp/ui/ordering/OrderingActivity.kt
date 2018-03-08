package kr.sofac.itsskinapp.ui.ordering

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_ordering.*
import kr.sofac.itsskinapp.R
import kr.sofac.itsskinapp.data.model.Cart
import kr.sofac.itsskinapp.data.model.callback.RequestCallback
import kr.sofac.itsskinapp.data.network.RequestManager
import kr.sofac.itsskinapp.data.network.dto.DTO
import kr.sofac.itsskinapp.util.AppPreference

class OrderingActivity : AppCompatActivity() {

    private lateinit var appPreference: AppPreference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ordering)

        val mapCart: MutableMap<String, Int> = mutableMapOf()
        appPreference = AppPreference(this)
        for(cartProduct in appPreference.getCartProducts()){
            mapCart[cartProduct.product.id.toString()] = cartProduct.amount
        }
        getCartInformation(mapCart, "")
        initToolbar()
        Handler().postDelayed({progressBarLoadingProduct.visibility = View.GONE},1000)
    }

    private fun initToolbar() {
        toolbar.title = "Оформление товара"
        setSupportActionBar(toolbar)
        toolbar.setNavigationIcon(R.drawable.arrow_left)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    private fun getCartInformation(shoppingCart : MutableMap<String, Int>, couponCode : String){
        RequestManager.getCart(DTO().setCartInfo(shoppingCart,couponCode), object : RequestCallback<Cart> {
            override fun onSuccess(data: Cart) {
//                view.onLoaded(data)
//                view.setLoading(false)
                Toast.makeText(applicationContext, "onSuccess", Toast.LENGTH_SHORT).show()
            }

            override fun onError(message: String) {
                Toast.makeText(applicationContext, "onError", Toast.LENGTH_SHORT).show()
//                view.onLoadError(message)
//                view.setLoading(false)
            }
        })
    }

//    private fun setOrder(shoppingCart : MutableMap<String, Int>, couponCode : String){
//        RequestManager.getCart(DTO().setCartInfo(shoppingCart,couponCode), object : RequestCallback<String> {
//            override fun onSuccess(data: String) {
////                view.onLoaded(data)
////                view.setLoading(false)
//                Toast.makeText(applicationContext, "onSuccess", Toast.LENGTH_SHORT).show()
//            }
//
//            override fun onError(message: String) {
//                Toast.makeText(applicationContext, "onError", Toast.LENGTH_SHORT).show()
////                view.onLoadError(message)
////                view.setLoading(false)
//            }
//        })
//    }
}
