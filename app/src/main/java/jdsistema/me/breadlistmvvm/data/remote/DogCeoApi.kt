package jdsistema.me.breadlistmvvm.data.remote

import retrofit2.Call
import retrofit2.http.GET

/**
 * Created on data 26/07/18.
 */
interface DogCeoApi {

    @GET("breeds/list")
    fun listBreeds(): Call<DogCeoResponse>

}