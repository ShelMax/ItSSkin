package kr.sofac.itsskin.ui.detail

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
import kr.sofac.itsskin.R
import kr.sofac.itsskin.data.model.Image
import kr.sofac.itsskin.data.model.Product
import kr.sofac.itsskin.util.AppPreference


class ProductDetailFragment : Fragment(), ProductDetailContract.View {

    override lateinit var presenter: ProductDetailContract.Presenter
    lateinit var appPreference: AppPreference

    override var isActive: Boolean = false
        get() = isAdded

    override fun onResume() {
        super.onResume()
        presenter.start()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        appPreference = AppPreference(inflater.context)
        return view
    }

    override fun fillProductDescription(product: Product) {
        textTitle.text = product.name
        textCodeProduct.text = product.variant?.sku
        textRateCircle.text = "OOOOO"
        textPrice.text = product.variant?.price

        textAvailables.text = if ("1" == product.visible) {
            textAvailables.setTextColor(resources.getColor(R.color.colorGreen))
            "Есть в наличии"
        } else {
            textAvailables.setTextColor(resources.getColor(R.color.colorRed))
            "Нет в наличии"
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            textDescriptionBody.text = Html.fromHtml(product.body, Html.FROM_HTML_MODE_COMPACT)
        } else {
            textDescriptionBody.text = Html.fromHtml(product.body)
        }

        addToCart.setOnClickListener {
            presenter.addProductToShopCart(appPreference)
            Toast.makeText(activity, "Product added to cart", Toast.LENGTH_SHORT).show()
        }

        for (feature in product.features!!) {
            val textView = TextView(activity)
            val text = "${feature.name}: ${feature.value}"
            textView.text = text
            linerLayoutFeatures.addView(textView)
        }

    }

    override fun showSimilarProductScroller(listProduct: List<Product>) {
        similarProductPageView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        similarProductPageView.adapter = ProductScrollingAdapter(listProduct)
        chevronLeft.setOnClickListener {

        }
        chevronRight.setOnClickListener {

        }
    }


    override fun showImageScroller(images: List<Image>) {
        imagePageView.adapter = ImageScrollerAdapter(activity, images)
        chevronLeft.setOnClickListener {

        }
        chevronRight.setOnClickListener {

        }
    }

    override fun hideSimilarProductScroller() {
        similarProductPageView.visibility = View.GONE
//        productRight.visibility = View.GONE
//        productLeft.visibility = View.GONE
        line5.visibility = View.GONE
        textTitleSimilarProduct.visibility = View.GONE
        line6.visibility = View.GONE
    }

    override fun showComments() {}


    override fun showToast(toast: String) {
        Toast.makeText(activity, toast, Toast.LENGTH_SHORT).show()
    }


    companion object {

        private val ARGUMENT_TASK_ID = "TASK_ID"

        private val REQUEST_EDIT_TASK = 1

        fun newInstance(taskId: String?) =
                ProductDetailFragment().apply {
                    arguments = Bundle().apply { putString(ARGUMENT_TASK_ID, taskId) }
                }
    }


}
