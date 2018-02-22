package kr.sofac.itsskinapp.ui.detail

import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_detail.*
import kr.sofac.itsskinapp.R
import kr.sofac.itsskinapp.data.model.Product
import kr.sofac.itsskinapp.util.AppPreference
import kr.sofac.itsskinapp.util.Constants


class ProductDetailFragment : Fragment(), ProductDetailContract.View {

    private lateinit var presenter: ProductDetailContract.Presenter
    private lateinit var appPreference: AppPreference
    private lateinit var product: Product

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        appPreference = AppPreference(activity!!.applicationContext)
        presenter = ProductDetailPresenter(this)
        presenter.loadProduct(arguments!!.getString(Constants.PRODUCT_URL, ""))
        return view
    }

    override fun onProductLoaded(product: Product) {
        this.product = product
        showImageScroller()
        fillProductDescription()
        if (product.relatedProducts == null || product.relatedProducts!!.isEmpty())
            hideSimilarProductScroller()
        else
            showSimilarProductScroller(product.relatedProducts ?: listOf())
        setLoading(false)
    }

    private fun fillProductDescription() {
        textTitle.text = product.name
        textCodeProduct.text = product.variant?.sku
        textRateCircle.text = "OOOOO"
        textPrice.text = product.variant?.price

        textAvailable.text = if ("1" == product.visible) {
            textAvailable.setTextColor(resources.getColor(R.color.colorGreen))
            "Есть в наличии"
        } else {
            textAvailable.setTextColor(resources.getColor(R.color.colorRed))
            "Нет в наличии"
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            textDescriptionBody.text = Html.fromHtml(product.body, Html.FROM_HTML_MODE_COMPACT)
        } else {
            textDescriptionBody.text = Html.fromHtml(product.body)
        }

        addToCart.setOnClickListener {
            appPreference.addProductToCart(product)
            Toast.makeText(activity, "Додано у кошик", Toast.LENGTH_SHORT).show()
        }

        for (feature in product.features!!) {
            val textView = TextView(activity)
            val text = "${feature.name}: ${feature.value}"
            textView.text = text
            linerLayoutFeatures.addView(textView)
        }

    }


    private fun showImageScroller() {
        imageViewPager.adapter = ImageScrollerAdapter(activity, product.images ?: listOf())

        arrowLeft.setOnClickListener {
            imageViewPager.setCurrentItem(imageViewPager.currentItem - 1, true)
        }
        arrowRight.setOnClickListener {
            imageViewPager.setCurrentItem(imageViewPager.currentItem + 1, true)
        }
    }


    private fun showSimilarProductScroller(listProduct: List<Product>) {
        similarProductPageView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        similarProductPageView.adapter = ScrollingProductAdapter(listProduct)
    }

    private fun hideSimilarProductScroller() {
        similarProductPageView.visibility = View.GONE
//        productRight.visibility = View.GONE
//        productLeft.visibility = View.GONE
        line5.visibility = View.GONE
        textTitleSimilarProduct.visibility = View.GONE
        line6.visibility = View.GONE
    }

    override fun showComments() {}

    override fun setLoading(isLoading: Boolean) {
        if (!isLoading){
            progressBarLoadingProduct.visibility = View.GONE
            scrollViewProduct.visibility = View.VISIBLE
        }
    }

    override fun onLoadError(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }

    companion object {

        fun newInstance(productURL: String?) =
                ProductDetailFragment().apply {
                    arguments = Bundle().apply { putString(Constants.PRODUCT_URL, productURL) }
                }
    }

}
