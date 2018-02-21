package kr.sofac.itsskinapp.data.model.callback

import kr.sofac.itsskinapp.data.model.Category

interface CategoryCallback {
    fun categoryClick(category: Category)
}