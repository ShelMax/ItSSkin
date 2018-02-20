package kr.sofac.itsskin.ui.detail

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kr.sofac.itsskin.R
import kr.sofac.itsskin.util.Constants
import kr.sofac.itsskin.util.replaceFragmentInActivity
import kr.sofac.itsskin.util.setupActionBar

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
                ?: ProductDetailFragment.newInstance(productUrl).also { replaceFragmentInActivity(it, R.id.contentFrame) }
        ProductDetailPresenter(productUrl, productDetailFragment)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


}
