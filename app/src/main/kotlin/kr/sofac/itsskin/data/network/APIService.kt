package kr.sofac.itsskin.data.network

import kr.sofac.itsskin.data.model.Category
import kr.sofac.itsskin.data.model.Product
import kr.sofac.itsskin.data.network.dto.DTO
import kr.sofac.itsskin.data.network.dto.ResponseObject
import kr.sofac.itsskin.data.network.dto.ServerRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface APIService {

    @POST("./")
    fun getCategories(@Body request : ServerRequest<String>) : Call<ResponseObject<List<Category>>>

    @POST("./")
    fun getCategoryProducts(@Body request : ServerRequest<DTO>) : Call<ResponseObject<List<Product>>>

    @POST("./")
    fun getProduct(@Body request : ServerRequest<DTO>) : Call<ResponseObject<Product>>
}