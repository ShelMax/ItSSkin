package kr.sofac.itsskinapp.data.network

import android.util.Log
import kr.sofac.itsskinapp.data.model.*
import kr.sofac.itsskinapp.data.model.callback.RequestCallback
import kr.sofac.itsskinapp.data.network.dto.DTO
import kr.sofac.itsskinapp.data.network.dto.ServerResponse
import kr.sofac.itsskinapp.data.network.dto.ServerRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RequestManager {

    companion object {
        private val apiService: APIService = RetrofitManager.getApiService()

        fun getCategories(callback: RequestCallback<List<Category>>) {
            apiService.getCategories(ServerRequest(ServerConfig.GET_CATEGORIES, "")).enqueue(object : Callback<ServerResponse<List<Category>>> {
                override fun onFailure(call: Call<ServerResponse<List<Category>>>?, t: Throwable?) {
                    callback.onError(t?.message!!)
                    Log.e("- getProduct-onFailure ", t.message!!)
                }

                override fun onResponse(call: Call<ServerResponse<List<Category>>>?, response: Response<ServerResponse<List<Category>>>?) {
                    callback.onSuccess(response?.body()?.dataTransferObject!!)
                }
            })
        }

        fun getCategoryProducts(dto: DTO, callback: RequestCallback<List<Product>>) {
            apiService.getCategoryProducts(ServerRequest(ServerConfig.GET_CATEGORY_PRODUCTS, dto)).enqueue(object : Callback<ServerResponse<List<Product>>> {
                override fun onFailure(call: Call<ServerResponse<List<Product>>>?, t: Throwable?) {
                    callback.onError(t?.message!!)
                    Log.e("- getProduct-onFailure ", t.message!!)
                }

                override fun onResponse(call: Call<ServerResponse<List<Product>>>?, response: Response<ServerResponse<List<Product>>>?) {
                    if (response!!.isSuccessful)
                        callback.onSuccess(response.body()?.dataTransferObject!!)
                    else
                        callback.onError("Виникла помилка")
                }
            })
        }


        fun getProduct(dto: DTO, callback: RequestCallback<ProductDetail>) {
            apiService.getProduct(ServerRequest(ServerConfig.GET_PRODUCT, dto))
                    .enqueue(object : Callback<ServerResponse<ProductDetail>> {
                        override fun onFailure(call: Call<ServerResponse<ProductDetail>>?, t: Throwable?) {
                            callback.onError(t?.message!!)
                            Log.e("- getProduct-onFailure ", t.message!!)
                        }

                        override fun onResponse(call: Call<ServerResponse<ProductDetail>>?, response: Response<ServerResponse<ProductDetail>>?) {
                            if (response!!.isSuccessful) {
                                callback.onSuccess(response.body()?.dataTransferObject!!)
                            } else {
                                callback.onError("Виникла помилка")
                            }

                        }
                    })
        }

        fun getCart(dto: DTO, callback: RequestCallback<Cart>) {
            apiService.getCart(ServerRequest(ServerConfig.GET_CART, dto))
                    .enqueue(object : Callback<ServerResponse<Cart>> {
                        override fun onFailure(call: Call<ServerResponse<Cart>>?, t: Throwable?) {
                            callback.onError(t?.message!!)
                            Log.e("- getCart-onFailure ", t.message!!)
                        }

                        override fun onResponse(call: Call<ServerResponse<Cart>>?, response: Response<ServerResponse<Cart>>?) {
                            if (response!!.isSuccessful) {
                                callback.onSuccess(response.body()?.dataTransferObject!!)
                            } else {
                                callback.onError("Виникла помилка")
                            }

                        }
                    })
        }

        fun setOrder(makeOrder: MakeOrder, callback: RequestCallback<EmptyResponseContainer>) {
            apiService.setOrder(ServerRequest(ServerConfig.SET_ORDER, makeOrder))
                    .enqueue(object : Callback<ServerResponse<EmptyResponseContainer>> {
                        override fun onFailure(call: Call<ServerResponse<EmptyResponseContainer>>?, t: Throwable?) {
                            callback.onError(t?.message!!)
                            Log.e("- setOrder-onFailure ", t.message!!)
                        }

                        override fun onResponse(call: Call<ServerResponse<EmptyResponseContainer>>?, response: Response<ServerResponse<EmptyResponseContainer>>?) {
                            if (response!!.isSuccessful) {
                                callback.onSuccess(response.body()?.dataTransferObject!!)
                            } else {
                                callback.onError("Виникла помилка")
                            }

                        }
                    })
        }

        fun setGoogleKey(googleCloudKey: String, callback: RequestCallback<String>) {
            apiService.setGoogleKey(ServerRequest(ServerConfig.SET_GOOGLE_KEY, GoogleCloudKey(googleCloudKey)))
                    .enqueue(object : Callback<ServerResponse<String>> {
                        override fun onFailure(call: Call<ServerResponse<String>>?, t: Throwable?) {
                            Log.e("GoogleKey-ErrorRequest", t?.message!!)
                            callback.onError(t.message!!)

                        }

                        override fun onResponse(call: Call<ServerResponse<String>>?, response: Response<ServerResponse<String>>?) {
                            if (response!!.isSuccessful) {
                                callback.onSuccess(response.body()?.dataTransferObject!!)
                            } else {
                                callback.onError("Виникла помилка")
                            }

                        }
                    })
        }
    }
}