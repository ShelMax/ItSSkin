package kr.sofac.itsskin.data.network

class ServerConfig {

    companion object {
        const val BASE_URL : String = "http://192.168.0.31/itsskin/data/ajax/request.php/"
        const val GET_CATEGORIES : String = "getCategoriesTree"
        const val GET_CATEGORY_PRODUCTS: String = "getProducts"
        const val GET_PRODUCT = "getProduct"
    }
}