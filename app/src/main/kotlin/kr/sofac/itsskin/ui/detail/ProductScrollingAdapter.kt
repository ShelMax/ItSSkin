package kr.sofac.itsskin.ui.detail

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_product_image_title_price.view.*
import kr.sofac.itsskin.R
import kr.sofac.itsskin.data.model.GlideApp
import kr.sofac.itsskin.data.model.Product
import kr.sofac.itsskin.data.network.ServerConfig

/**
 * Created by Maxim on 2/20/2018.
 */
class ProductScrollingAdapter(val listProducts: List<Product>) : RecyclerView.Adapter<ProductScrollingAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent?.context).inflate(R.layout.item_product_image_title_price, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listProducts.size
    }

    override fun onBindViewHolder(holder: ProductScrollingAdapter.ViewHolder, position: Int) {
        holder.itemView.textTitleProduct.text = listProducts[position].name
        holder.itemView.textPriceProduct.text = listProducts[position].variant?.price
        GlideApp.with(holder.itemView)
                .load(ServerConfig.IMAGE_URL + listProducts[position].image!!.filename)
                .override(600, 600)
                .into(holder.itemView.imageSimilarProduct)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

}