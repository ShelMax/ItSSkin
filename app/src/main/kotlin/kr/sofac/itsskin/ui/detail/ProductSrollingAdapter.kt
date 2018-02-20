package kr.sofac.itsskin.ui.detail

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import kr.sofac.itsskin.data.model.Product

/**
 * Created by Maxim on 2/20/2018.
 */
class ProductSrollingAdapter(val listProducts: List<Product> ): RecyclerView.Adapter<ProductSrollingAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view)
}