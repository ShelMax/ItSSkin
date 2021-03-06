package kr.sofac.itsskinua.data.network

import kr.sofac.itsskinua.data.model.*
import kr.sofac.itsskinua.data.network.dto.DTO
import kr.sofac.itsskinua.data.network.dto.ServerRequest
import kr.sofac.itsskinua.data.network.dto.ServerResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface APIService {

    @POST("./")
    fun getCategories(@Body request : ServerRequest<String>) : Call<ServerResponse<List<Category>>>

    @POST("./")
    fun getCategoryProducts(@Body request : ServerRequest<DTO>) : Call<ServerResponse<List<Product>>>

    @POST("./")
    fun getProduct(@Body request : ServerRequest<DTO>) : Call<ServerResponse<ProductDetail>>

    @POST("./")
    fun getCart(@Body request : ServerRequest<DTO>) : Call<ServerResponse<Cart>>

    @POST("./")
    fun setOrder(@Body request : ServerRequest<MakeOrder>) : Call<ServerResponse<EmptyResponseContainer>>

    @POST("./")
    fun setGoogleKey(@Body request : ServerRequest<GoogleCloudKey>) : Call<ServerResponse<String>>
}