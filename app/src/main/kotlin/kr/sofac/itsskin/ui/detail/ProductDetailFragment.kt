package kr.sofac.itsskin.ui.detail

import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_detail.*
import kr.sofac.itsskin.R
import kr.sofac.itsskin.data.model.Product


class ProductDetailFragment : Fragment(), ProductDetailContract.View {


    override lateinit var presenter: ProductDetailContract.Presenter

    override var isActive: Boolean = false
        get() = isAdded

    override fun onResume() {
        super.onResume()
        presenter.start()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        return view
    }

    override fun fillProductDescription(product: Product) {
        textTitle.text = product.name
        textAvailables.text = if ("1".equals(product.visible)) {
            textAvailables.setTextColor(resources.getColor(R.color.colorGreen))
            "Есть в наличии"
        } else {
            textAvailables.setTextColor(resources.getColor(R.color.colorRed))
            "Нет в наличии"
        }
        textCodeProduct.text = product.variant?.sku
        textPrice.text = product.variant?.price
        textRateCircle.text = "OOOOO"

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            textDescriptionBody.text = Html.fromHtml(product.body, Html.FROM_HTML_MODE_COMPACT)
        } else {
            textDescriptionBody.text = Html.fromHtml(product.body)
        }

        for (feature in product.features!!) {
            val textView = TextView(activity)
            val text = "${feature.name}: ${feature.value}"
            textView.text = text
            linerLayoutFeatures.addView(textView)
        }

    }

    override fun showSameProductScroller(listProduct: List<Product>) {

    }

    override fun showImageScroller(adapter: ImageScrollerAdapter) {
//        imagePageView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
//        imagePageView.layoutManager.isAutoMeasureEnabled = false

        imagePageView.adapter = adapter
//        chevronLeft.setOnClickListener {
//            if (imagePageView.verticalScrollbarPosition - 1 >= 0)
//                imagePageView.smoothScrollToPosition(imagePageView.verticalScrollbarPosition - 1)
//        }
//        chevronRight.setOnClickListener {
//            showToast("${imagePageView.verticalScrollbarPosition}")
//            if (imagePageView.adapter.itemCount >= imagePageView.verticalScrollbarPosition + 1)
//                imagePageView.smoothScrollToPosition(imagePageView.verticalScrollbarPosition + 1) //TODO finish control button image
//        }
    }

    override fun showComments() {}


    override fun showLoadingIndicator() {}


    override fun hideLoadingIndicator() {}


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
