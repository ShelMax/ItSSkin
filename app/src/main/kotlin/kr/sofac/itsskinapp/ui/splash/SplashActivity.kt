package kr.sofac.itsskinapp.ui.splash

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kr.sofac.itsskinapp.R
import kr.sofac.itsskinapp.data.model.Category
import kr.sofac.itsskinapp.ui.navigation.NavigationActivity
import kr.sofac.itsskinapp.util.AppPreference

class SplashActivity : AppCompatActivity(), SplashContract.View {

    private lateinit var presenter : SplashContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        presenter = SplashPresenter(this)
        presenter.loadCategories()
    }

    override fun setLoading(isLoading: Boolean) {
        if(isLoading){

        }
        else{

        }
    }

    override fun onLoadError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onLoaded(categories: List<Category>) {
        AppPreference(this).setCategories(categories)
        startActivity(Intent(this, NavigationActivity::class.java)
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
        finishAffinity()
    }
}
