package kr.sofac.itsskinapp.ui.detail

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.text.Html
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.mancj.slideup.SlideUp
import com.mancj.slideup.SlideUpBuilder
import kotlinx.android.synthetic.main.fragment_detail.*
import kr.sofac.itsskinapp.R
import kr.sofac.itsskinapp.data.model.Image
import kr.sofac.itsskinapp.data.model.Product
import kr.sofac.itsskinapp.util.AppPreference
import kr.sofac.itsskinapp.util.Constants

class ProductDetailFragment : Fragment(), ProductDetailContract.View {

    private lateinit var appPreference: AppPreference

    override lateinit var presenter: ProductDetailContract.Presenter

    override var isActive: Boolean = false
        get() = isAdded

    override fun onResume() {
        super.onResume()
        presenter.start()
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        appPreference = AppPreference(view.context)
        return view
    }

    override fun fillProductDescription(product: Product) {

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
            Snackbar.make(addToCart, "Додано у кошик", Snackbar.LENGTH_LONG).show()
        }

        buttonShowComments.setOnClickListener{
            showToastMessage("Hello its SlideUp")
            val textViewSec = TextView(activity)
            textViewSec.text = "Comments"
//            val slideUp = SlideUpBuilder(progressBarLoadingProduct)
//                    .withStartState(SlideUp.State.HIDDEN)
//                    .withStartGravity(Gravity.BOTTOM)
//                    .withListeners(object : SlideUp.Listener.Events {
//                        override fun onSlide(percent: Float) {
//                            slideUp.setAlpha(1 - percent / 100)
//                        }
//
//                        override fun onVisibilityChanged(visibility: Int) {
//                            if (visibility == View.GONE) {
//
//                            }
//                        }
//                    })
//                    .withGesturesEnabled(true)
//                    .build()
        }

        linerLayoutFeatures.removeAllViewsInLayout()
        for (feature in product.features!!) {
            val textView = TextView(activity)
            val text = "${feature.name}: ${feature.value}"
            textView.text = text
            linerLayoutFeatures.addView(textView)
        }

    }

    override fun showImageViewPager(images: List<Image>) {
        imageViewPager.adapter = ImageScrollerAdapter(activity, images)

        arrowLeft.setOnClickListener {
            imageViewPager.setCurrentItem(imageViewPager.currentItem - 1, true)
        }
        arrowRight.setOnClickListener {
            imageViewPager.setCurrentItem(imageViewPager.currentItem + 1, true)
        }
    }

    override fun showSimilarProductScroller(listProduct: List<Product>) {
        similarProductPageView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        similarProductPageView.adapter = ScrollingProductAdapter(listProduct, object : ScrollingProductAdapter.OnItemClickListener {
            override fun onMyClick(position: Int) {
                startActivity(Intent(activity, ProductDetailActivity::class.java).putExtra(Constants.PRODUCT_URL, listProduct[position].url))
            }
        })
    }

    override fun hideSimilarProductScroller() {
        similarProductPageView.visibility = View.GONE
        line5.visibility = View.GONE
        textTitleSimilarProduct.visibility = View.GONE
        line6.visibility = View.GONE
    }

    override fun showCommentsView() {
        showToastMessage("Open comments!")
    }

    override fun showLoadingProgressBar() {
        progressBarLoadingProduct.visibility = View.VISIBLE
        scrollViewProduct.visibility = View.GONE
    }

    override fun hideLoadingProgressBar() {
        progressBarLoadingProduct.visibility = View.GONE
        scrollViewProduct.visibility = View.VISIBLE
    }

    override fun showToastMessage(toastMessage: String) {
        Toast.makeText(activity, toastMessage, Toast.LENGTH_SHORT).show()
    }

    override fun showMessageInSnackBar() {

    }

    ////////////// TODO Need learn this moment
    companion object {
        fun newInstance(productURL: String?) =
                ProductDetailFragment().apply {
                    arguments = Bundle().apply { putString(Constants.PRODUCT_URL, productURL) }
                }
    }

}
