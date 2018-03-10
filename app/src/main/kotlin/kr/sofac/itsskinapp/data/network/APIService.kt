package kr.sofac.itsskinapp.data.network

import kr.sofac.itsskinapp.data.model.Cart
import kr.sofac.itsskinapp.data.model.Category
import kr.sofac.itsskinapp.data.model.Product
import kr.sofac.itsskinapp.data.network.dto.DTO
import kr.sofac.itsskinapp.data.network.dto.ServerResponse
import kr.sofac.itsskinapp.data.network.dto.ServerRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface APIService {

    @POST("./")
    fun getCategories(@Body request : ServerRequest<String>) : Call<ServerResponse<List<Category>>>

    @POST("./")
    fun getCategoryProducts(@Body request : ServerRequest<DTO>) : Call<ServerResponse<List<Product>>>

    @POST("./")
    fun getProduct(@Body request : ServerRequest<DTO>) : Call<ServerResponse<Product>>

    @POST("./")
    fun getCart(@Body request : ServerRequest<DTO>) : Call<ServerResponse<Cart>>
}