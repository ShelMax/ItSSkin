package kr.sofac.itsskinapp.ui.navigation

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.view.View
import kr.sofac.itsskinapp.data.model.Product
import android.view.LayoutInflater
import kr.sofac.itsskinapp.R
import kr.sofac.itsskinapp.data.network.ServerConfig
import kotlinx.android.synthetic.main.item_grid.view.*
import kr.sofac.itsskinapp.data.model.GlideApp
import kr.sofac.itsskinapp.data.model.callback.GridCallback

//TODO Progress dialog everywhere


class GridAdapter(private val products: List<Product>, private val callback : GridCallback) : RecyclerView.Adapter<GridAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.item_grid, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: GridAdapter.ViewHolder, position: Int) {
        GlideApp.with(holder.itemView)
                .load(ServerConfig.IMAGE_URL + products[position*2].image?.filename)
                .override(400,400)
//                .apply(RequestOptions().placeholder(R.drawable.placeholder_image))
                .into(holder.itemView.imageFirst)
        holder.itemView.titleFirst.text = products[position*2].metaTitle
        holder.itemView.priceFirst.text = products[position*2].variant?.price
        holder.itemView.constraintFirst.setOnClickListener({ callback.itemClick(position * 2) })
        holder.itemView.addToCartFirst.setOnClickListener { callback.addToCartClick(position*2) }
        if (position * 2 != products.size - 1) {
            GlideApp.with(holder.itemView)
                    .load(ServerConfig.IMAGE_URL + products[position*2 + 1].image?.filename)
//                    .apply(RequestOptions().placeholder(R.drawable.placeholder_image))
                    .override(400,400)
                    .into(holder.itemView.imageSecond)
            holder.itemView.titleSecond.text = products[position * 2 + 1].metaTitle
            holder.itemView.priceSecond.text = products[position * 2 + 1].variant?.price
            holder.itemView.constraintSecond.setOnClickListener { callback.itemClick(position * 2 + 1) }
            holder.itemView.addToCartSecond.setOnClickListener { callback.addToCartClick(position * 2 + 1) }
        } else {
            holder.itemView.imageSecond.visibility = View.GONE
            holder.itemView.titleSecond.visibility = View.GONE
            holder.itemView.addToCartSecond.visibility = View.GONE
        }
    }

    override fun getItemCount(): Int {
        return Math.round(products.size.toDouble() / 2).toInt()
    }

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view)
}