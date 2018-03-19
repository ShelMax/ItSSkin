package kr.sofac.itsskinua.data.model.callback

import kr.sofac.itsskinua.data.model.Category

interface CategoryCallback {
    fun categoryClick(category: Category)
}