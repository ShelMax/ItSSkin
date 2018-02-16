package kr.sofac.itsskin.ui.detail

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kr.sofac.itsskin.R

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


}
