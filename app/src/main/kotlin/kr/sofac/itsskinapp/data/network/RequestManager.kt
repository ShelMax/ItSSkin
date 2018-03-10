package kr.sofac.itsskinapp.data.network

import android.util.Log
import kr.sofac.itsskinapp.data.model.Cart
import kr.sofac.itsskinapp.data.model.callback.RequestCallback
import kr.sofac.itsskinapp.data.model.Category
import kr.sofac.itsskinapp.data.network.dto.DTO
import kr.sofac.itsskinapp.data.model.Product
import kr.sofac.itsskinapp.data.network.dto.ServerResponse
import kr.sofac.itsskinapp.data.network.dto.ServerRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RequestManager {

    companion object {
        private val apiService : APIService = RetrofitManager.getApiService()

        fun getCategories(callback : RequestCallback<List<Category>>){
            apiService.getCategories(ServerRequest(ServerConfig.GET_CATEGORIES, "")).enqueue(object : Callback<ServerResponse<List<Category>>>{
                override fun onFailure(call: Call<ServerResponse<List<Category>>>?, t: Throwable?) {
                    callback.onError(t?.message!!)
                    Log.e("- getProduct-onFailure ", t.message!!)
                }

                override fun onResponse(call: Call<ServerResponse<List<Category>>>?, response: Response<ServerResponse<List<Category>>>?) {
                    callback.onSuccess(response?.body()?.dataTransferObject!!)
                }
            })
        }

        fun getCategoryProducts(dto : DTO, callback : RequestCallback<List<Product>>){
            apiService.getCategoryProducts(ServerRequest(ServerConfig.GET_CATEGORY_PRODUCTS, dto)).enqueue(object : Callback<ServerResponse<List<Product>>>{
                override fun onFailure(call: Call<ServerResponse<List<Product>>>?, t: Throwable?) {
                    callback.onError(t?.message!!)
                    Log.e("- getProduct-onFailure ", t.message!!)
                }

                override fun onResponse(call: Call<ServerResponse<List<Product>>>?, response: Response<ServerResponse<List<Product>>>?) {
                    if(response!!.isSuccessful)
                        callback.onSuccess(response.body()?.dataTransferObject!!)
                    else
                        callback.onError("Виникла помилка")
                }
            })
        }


        fun getProduct(dto : DTO, callback : RequestCallback<Product>){
            apiService.getProduct(ServerRequest(ServerConfig.GET_PRODUCT, dto))
                    .enqueue(object : Callback<ServerResponse<Product>>{
                override fun onFailure(call: Call<ServerResponse<Product>>?, t: Throwable?) {
                    callback.onError(t?.message!!)
                    Log.e("- getProduct-onFailure ", t.message!!)
                }

                override fun onResponse(call: Call<ServerResponse<Product>>?, response: Response<ServerResponse<Product>>?) {
                    if(response!!.isSuccessful){
                        callback.onSuccess(response.body()?.dataTransferObject!!)
                    }
                    else{

                    }

                }
            })
        }

        fun getCart(dto : DTO, callback : RequestCallback<Cart>){
            apiService.getCart(ServerRequest(ServerConfig.GET_CART, dto))
                    .enqueue(object : Callback<ServerResponse<Cart>>{
                        override fun onFailure(call: Call<ServerResponse<Cart>>?, t: Throwable?) {
                            callback.onError(t?.message!!)
                            Log.e("- getProduct-onFailure ", t.message!!)
                        }

                        override fun onResponse(call: Call<ServerResponse<Cart>>?, response: Response<ServerResponse<Cart>>?) {
                            if(response!!.isSuccessful){
                                callback.onSuccess(response.body()?.dataTransferObject!!)
                            }
                            else{

                            }

                        }
                    })
        }
    }
}