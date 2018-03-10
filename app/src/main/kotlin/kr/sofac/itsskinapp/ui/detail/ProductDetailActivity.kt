package kr.sofac.itsskinapp.ui.detail

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kr.sofac.itsskinapp.R
import kr.sofac.itsskinapp.ui.cart.CartActivity
import kr.sofac.itsskinapp.util.Constants
import kr.sofac.itsskinapp.util.replaceFragmentInActivity
import kr.sofac.itsskinapp.util.setupActionBar

class ProductDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val productUrl = intent.getStringExtra(Constants.PRODUCT_URL)

        setupActionBar(R.id.toolbar){
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setDisplayShowTitleEnabled(false)
        }
        val productDetailFragment = supportFragmentManager.findFragmentById(R.id.contentFrame) as ProductDetailFragment?
                ?: ProductDetailFragment.newInstance(productUrl).also {
                    replaceFragmentInActivity(it, R.id.contentFrame)
                }
        // Create the presenter
        ProductDetailPresenter(productUrl, productDetailFragment)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_cart_dark, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            R.id.cart -> {
                startActivity(Intent(this, CartActivity::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}
