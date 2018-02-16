package kr.sofac.itsskin.ui.navigation

import android.content.Context
import android.support.v7.widget.LinearLayoutManager

class NoScrollManager(context : Context, orientation : Int,
                      reverseLayout : Boolean) : LinearLayoutManager(context, orientation, reverseLayout) {

    override fun canScrollVertically(): Boolean {
        return false
    }


}