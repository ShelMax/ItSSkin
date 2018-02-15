package kr.sofac.itsskin.ui.navigation

import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_navigation.*
import kr.sofac.itsskin.R
import kr.sofac.itsskin.data.model.Category
import kr.sofac.itsskin.util.AppPreference

class NavigationActivity : AppCompatActivity(){

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
        init()
        supportFragmentManager.beginTransaction()
                .add(R.id.navigationFragment, GridFragment())
                .commit()
    }

    private fun init(){
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        initDrawerMenu()
    }

    private fun initDrawerMenu() {
        val categories : List<Category> = AppPreference(this).getCategories()

    }


}
