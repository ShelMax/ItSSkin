package kr.sofac.itsskinapp.ui.cart

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_product_checkout.view.*
import kr.sofac.itsskinapp.R
import kr.sofac.itsskinapp.data.model.CartProduct
import kr.sofac.itsskinapp.data.model.GlideApp
import kr.sofac.itsskinapp.data.model.callback.CartCallback
import kr.sofac.itsskinapp.data.network.ServerConfig

class CartAdapter(private var products : MutableList<CartProduct>, private var callback: CartCallback) :
        RecyclerView.Adapter<CartAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.item_product_checkout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = products.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        GlideApp.with(holder.itemView)
                .load(ServerConfig.IMAGE_URL + products[position].product.image?.filename)
                .into(holder.itemView.productImage)
        holder.itemView.productTitle.text = products[position].product.metaTitle
        holder.itemView.productAmount.text = products[position].amount.toString()
        holder.itemView.productPrice.text = (products[position].product.variant?.price + " ГРН")
        holder.itemView.amountAdd.setOnClickListener {
            products[position].amount++
            holder.itemView.productAmount.text = products[position].amount.toString()
            callback.amountChanged()
        }
        holder.itemView.amountSubtract.setOnClickListener {
            if(products[position].amount != 1) {
                products[position].amount--
                holder.itemView.productAmount.text = products[position].amount.toString()
            }
            else{
                callback.removeProduct(position)
                notifyDataSetChanged()
            }
            callback.amountChanged()
        }
    }

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view)
}