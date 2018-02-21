package kr.sofac.itsskin.ui.detail

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.ViewGroup
import kr.sofac.itsskin.data.model.Image
import android.view.LayoutInflater
import kotlinx.android.synthetic.main.item_image.view.*
import kr.sofac.itsskin.R
import kr.sofac.itsskin.data.model.GlideApp
import kr.sofac.itsskin.data.network.ServerConfig


/**
 * Created by Maxim on 2/20/2018.
 */

class ImageScrollerAdapter(val context: Context?, var listImages: List<Image>) : PagerAdapter() {

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = LayoutInflater.from(context)
        var view = inflater.inflate(R.layout.item_image, container, false)
        GlideApp.with(view)
                .load(ServerConfig.IMAGE_URL + listImages[position].filename)
                .override(600, 600)
                .into(view.imageScrolling)
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View?)
    }

    override fun getCount(): Int {
        return listImages.size
    }

}