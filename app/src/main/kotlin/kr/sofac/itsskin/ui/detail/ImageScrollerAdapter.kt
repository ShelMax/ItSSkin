package kr.sofac.itsskin.ui.detail

import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.ViewGroup
import kr.sofac.itsskin.data.model.Image

/**
 * Created by Maxim on 2/20/2018.
 */

class ImageScrollerAdapter(var listImages: List<Image>) : PagerAdapter() {

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        return super.instantiateItem(container, position)
    }

    override fun getCount(): Int {
        return listImages.size
    }


//    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
//        val view: View = LayoutInflater.from(parent?.context).inflate(R.layout.item_image, parent, false)
//        view.layoutParams = RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
//        return ViewHolder(view)
//    }
//
//    override fun getItemCount(): Int {
//        return listImages.size
//    }
//
//    override fun onBindViewHolder(holder: ImageScrollerAdapter.ViewHolder, position: Int) {
//        GlideApp.with(holder.itemView)
//                .load(ServerConfig.IMAGE_URL + listImages[position].filename)
//                .override(600,600)
//                .into(holder.itemView.imageScrolling)
//    }
//
//    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

}