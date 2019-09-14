package ch.risdesign.chucknorrisnerdjokes.model.networking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MyRetrofitClient {

    val apiClient: MyServiceInterface

    init {
        val retrofitClient = Retrofit.Builder()
            .baseUrl("https://api.chucknorris.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiClient = retrofitClient.create(MyServiceInterface::class.java)


    }
}