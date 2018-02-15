package kr.sofac.itsskin.data.network

class ServerConfig {

    companion object {
        private const val BASE_URL : String = "http://192.168.0.31/itsskin/"
        private const val PART_REQUEST : String = "data/ajax/request.php/"
        const val PART_PRODUCT_IMAGE : String = "files/originals/"

        const val REQUEST_URL : String = BASE_URL + PART_REQUEST
        const val IMAGE_URL :String = BASE_URL + PART_PRODUCT_IMAGE




        // Requests
        const val GET_CATEGORIES : String = "getCategoriesTree"
        const val GET_CATEGORY_PRODUCTS: String = "getProducts"
        const val GET_PRODUCT = "getProduct"
    }
}