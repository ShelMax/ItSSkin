package kr.sofac.itsskin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var backPressed: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val webSettings: WebSettings = webViewItSSkin.settings
        webSettings.javaScriptEnabled = true

        webViewItSSkin!!.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                buttonBack.visibility = View.VISIBLE
                return true
            }
        }

        webViewItSSkin!!.loadUrl("http://itsskin.gq/")
        buttonBack.visibility = View.GONE
        WebView.setWebContentsDebuggingEnabled(false)

        buttonBack.setOnClickListener({
            onClickBackWebView()
        })
    }

    private fun onClickBackWebView(){
        if (webViewItSSkin!!.canGoBack()) {
            webViewItSSkin.goBack()
            if (!webViewItSSkin!!.canGoBack())
                buttonBack.visibility = View.GONE
        }
    }

    override fun onBackPressed() {
        if (backPressed + 2000 > System.currentTimeMillis()) {
            super.onBackPressed()
            finishAffinity()
        } else {
            onClickBackWebView()
            Toast.makeText(baseContext, "Please click BACK again to exit" +
                    "", Toast.LENGTH_SHORT).show()
        }
        backPressed = System.currentTimeMillis()
    }


}
