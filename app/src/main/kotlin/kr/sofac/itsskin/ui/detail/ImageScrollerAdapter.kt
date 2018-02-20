package kr.sofac.itsskin.ui.detail

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_image.view.*
import kr.sofac.itsskin.R
import kr.sofac.itsskin.data.model.GlideApp
import kr.sofac.itsskin.data.model.Image
import kr.sofac.itsskin.data.network.ServerConfig

/**
 * Created by Maxim on 2/20/2018.
 */
class ImageScrollerAdapter(var listImages: List<Image>) : RecyclerView.Adapter<ImageScrollerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent?.context).inflate(R.layout.item_image, parent, false)
        view.layoutParams = RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listImages.size
    }

    override fun onBindViewHolder(holder: ImageScrollerAdapter.ViewHolder, position: Int) {
        GlideApp.with(holder.itemView)
                .load(ServerConfig.IMAGE_URL + listImages[position].filename)
                .override(600,600)
                .into(holder.itemView.imageScrolling)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

}