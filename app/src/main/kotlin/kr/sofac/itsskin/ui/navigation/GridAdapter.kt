package kr.sofac.itsskin.ui.navigation

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.view.View
import kr.sofac.itsskin.data.model.Product
import android.view.LayoutInflater
import com.bumptech.glide.request.RequestOptions
import kr.sofac.itsskin.R
import kr.sofac.itsskin.data.model.GlideApp
import kr.sofac.itsskin.data.network.ServerConfig
import kotlinx.android.synthetic.main.item_grid.view.*
import kr.sofac.itsskin.data.model.callback.GridCallback


class GridAdapter(private val products: List<Product>, private val callback : GridCallback) : RecyclerView.Adapter<GridAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.item_grid, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: GridAdapter.ViewHolder, position: Int) {
                GlideApp.with(holder.itemView)
                .load(ServerConfig.IMAGE_URL + products[position*2].image?.filename)
                .override(100, 100)
//                .apply(RequestOptions().placeholder(R.drawable.placeholder_image))
                .into(holder.itemView.imageFirst)
        holder.itemView.titleFirst.text = products[position*2].metaTitle
        holder.itemView.constraintFirst.setOnClickListener({ callback.itemClick(position * 2) })
        if (position * 2 != products.size - 1) {
            GlideApp.with(holder.itemView)
                    .load(ServerConfig.IMAGE_URL + products[position*2 + 1].image?.filename)
                    .override(100, 100)
                    //.apply(RequestOptions().placeholder(R.drawable.placeholder_image))
                    .into(holder.itemView.imageSecond)
            holder.itemView.titleSecond.text = products[position * 2 + 1].metaTitle
            holder.itemView.constraintSecond.setOnClickListener { callback.itemClick(position * 2 + 1) }
        } else {
            holder.itemView.constraintSecond.setVisibility(View.GONE)
        }
    }

    override fun getItemCount(): Int {
        return Math.round(products.size.toDouble() / 2).toInt()
    }

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view)
}