package kr.sofac.itsskinua.ui.navigation

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_grid.view.*
import kr.sofac.itsskinua.R
import kr.sofac.itsskinua.data.model.Product
import kr.sofac.itsskinua.data.model.callback.GridCallback
import kr.sofac.itsskinua.util.AppPreference
import kr.sofac.itsskinua.ui.detail.ProductDetailActivity
import kr.sofac.itsskinua.util.Constants

class GridFragment : Fragment(), NavigationGridContract.View {

    private lateinit var presenter: NavigationGridContract.Presenter
    private lateinit var adapter: GridAdapter
    private lateinit var products: MutableList<Product>
    private lateinit var appPreference: AppPreference


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_grid, container, false)
        products = arrayListOf()
        appPreference = AppPreference(activity?.applicationContext!!)
        adapter = GridAdapter(products, object : GridCallback {
            override fun itemClick(position: Int) {
                startDetailProductActivity(products[position].url)
            }

            override fun addToCartClick(position: Int) {
                appPreference.addProductToCart(products[position])
                Snackbar.make(view, "Додано у кошик", Toast.LENGTH_SHORT).show()
            }
        })
        view.gridRecycler.layoutManager = LinearLayoutManager(activity)
        view.gridRecycler.adapter = adapter
        presenter = NavigationGridPresenter(this)
        presenter.loadDefaultProducts()
        return view
    }

    override fun onProductsLoaded(loadedProducts: MutableList<Product>) {
        products.clear()
        products.addAll(loadedProducts)
        adapter.notifyDataSetChanged()
    }

    override fun onLoadError(message: String) {
        val snackBar = Snackbar.make(view!!, "В категорії нема товарів або сталася помилка", Toast.LENGTH_SHORT)
        val snackBarView = snackBar.view
        snackBarView.setBackgroundColor(Color.parseColor("#ffff0000"))
        snackBar.show()
    }

    fun loadCategoryProducts(categoryURL : String){
        presenter.loadCategoryProducts(categoryURL)
    }

    override fun startDetailProductActivity(productURL: String?) {
        val intent = Intent(activity, ProductDetailActivity::class.java)
        intent.putExtra(Constants.PRODUCT_URL, productURL)
        startActivity(intent)
    }
}