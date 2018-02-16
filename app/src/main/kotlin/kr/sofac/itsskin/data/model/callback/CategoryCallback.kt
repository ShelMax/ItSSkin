package kr.sofac.itsskin.data.model.callback

import kr.sofac.itsskin.data.model.Category

interface CategoryCallback {
    fun categoryClick(category: Category)
}