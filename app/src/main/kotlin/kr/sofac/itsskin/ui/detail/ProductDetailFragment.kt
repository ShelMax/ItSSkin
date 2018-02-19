package kr.sofac.itsskin.ui.detail


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kr.sofac.itsskin.R
import kr.sofac.itsskin.data.model.Product


/**
 * A simple [Fragment] subclass.
 */
class ProductDetailFragment : Fragment(), ProductDetailContract.View {

    override lateinit var presenter: ProductDetailContract.Presenter
    override var isActive: Boolean = false
        get() = isAdded


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }


    override fun showProduct(product: Product){

    }

    override fun showToast(toast: String){}

    override fun hideToast(){}

    companion object {

        private val ARGUMENT_TASK_ID = "TASK_ID"

        private val REQUEST_EDIT_TASK = 1

        fun newInstance(taskId: String?) =
                ProductDetailFragment().apply {
                    arguments = Bundle().apply { putString(ARGUMENT_TASK_ID, taskId) }
                }
    }

}// Required empty public constructor
