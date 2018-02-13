package kr.sofac.itsskin.ui.spalsh

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kr.sofac.itsskin.R
import kr.sofac.itsskin.ui.navigation.NavigationActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        waitingLoading()
    }

    private fun waitingLoading() {
        Handler().postDelayed({
            startWebActivity()
        }, 2000)
    }

    private fun startWebActivity() {
        val intent = Intent(this, NavigationActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
        finishAffinity()
    }


}
