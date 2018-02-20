package kr.sofac.itsskin.ui.detail

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
    }

    override fun showSameProductScroller(listProduct: List<Product>) {

    }

    override fun showImageScroller(adapter: ImageScrollerAdapter) {
        imageScrollingRecycler.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        imageScrollingRecycler.layoutManager.isAutoMeasureEnabled = false
        imageScrollingRecycler.adapter = adapter
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
