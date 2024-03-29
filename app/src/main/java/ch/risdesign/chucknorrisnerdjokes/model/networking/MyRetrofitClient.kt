package ch.risdesign.chucknorrisnerdjokes.model.networking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// THis is the retrofit class to handle the api request
class MyRetrofitClient {

    val apiClient: MyServiceInterface

    init {
        // This is the retrofit to get the random joke
        val retrofitClient = Retrofit.Builder()
            .baseUrl("https://api.chucknorris.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiClient = retrofitClient.create(MyServiceInterface::class.java)
    }
}