package kr.sofac.itsskinapp.data.network

import android.util.Log
import kr.sofac.itsskinapp.data.model.Cart
import kr.sofac.itsskinapp.data.model.callback.RequestCallback
import kr.sofac.itsskinapp.data.model.Category
import kr.sofac.itsskinapp.data.network.dto.DTO
import kr.sofac.itsskinapp.data.model.Product
import kr.sofac.itsskinapp.data.network.dto.ResponseObject
import kr.sofac.itsskinapp.data.network.dto.ServerRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RequestManager {

    companion object {
        private val apiService : APIService = RetrofitManager.getApiService()

        fun getCategories(callback : RequestCallback<List<Category>>){
            apiService.getCategories(ServerRequest(ServerConfig.GET_CATEGORIES, "")).enqueue(object : Callback<ResponseObject<List<Category>>>{
                override fun onFailure(call: Call<ResponseObject<List<Category>>>?, t: Throwable?) {
                    callback.onError(t?.message!!)
                    Log.e("- getProduct-onFailure ", t.message!!)
                }

                override fun onResponse(call: Call<ResponseObject<List<Category>>>?, response: Response<ResponseObject<List<Category>>>?) {
                    callback.onSuccess(response?.body()?.dataTransferObject!!)
                }
            })
        }

        fun getCategoryProducts(dto : DTO, callback : RequestCallback<List<Product>>){
            apiService.getCategoryProducts(ServerRequest(ServerConfig.GET_CATEGORY_PRODUCTS, dto)).enqueue(object : Callback<ResponseObject<List<Product>>>{
                override fun onFailure(call: Call<ResponseObject<List<Product>>>?, t: Throwable?) {
                    callback.onError(t?.message!!)
                    Log.e("- getProduct-onFailure ", t.message!!)
                }

                override fun onResponse(call: Call<ResponseObject<List<Product>>>?, response: Response<ResponseObject<List<Product>>>?) {
                    if(response!!.isSuccessful)
                        callback.onSuccess(response.body()?.dataTransferObject!!)
                    else
                        callback.onError("Виникла помилка")
                }
            })
        }


        fun getProduct(dto : DTO, callback : RequestCallback<Product>){
            apiService.getProduct(ServerRequest(ServerConfig.GET_PRODUCT, dto))
                    .enqueue(object : Callback<ResponseObject<Product>>{
                override fun onFailure(call: Call<ResponseObject<Product>>?, t: Throwable?) {
                    callback.onError(t?.message!!)
                    Log.e("- getProduct-onFailure ", t.message!!)
                }

                override fun onResponse(call: Call<ResponseObject<Product>>?, response: Response<ResponseObject<Product>>?) {
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
                    .enqueue(object : Callback<ResponseObject<Cart>>{
                        override fun onFailure(call: Call<ResponseObject<Cart>>?, t: Throwable?) {
                            callback.onError(t?.message!!)
                            Log.e("- getProduct-onFailure ", t.message!!)
                        }

                        override fun onResponse(call: Call<ResponseObject<Cart>>?, response: Response<ResponseObject<Cart>>?) {
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