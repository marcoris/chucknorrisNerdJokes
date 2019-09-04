package ch.risdesign.chucknorrisnerdjokes.model.networking

import android.util.Log
import ch.risdesign.chucknorrisnerdjokes.model.Joke
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MyRetrofitClient {

    val apiClient: MeServiceInterface

    init {
        val retrofitClient = Retrofit.Builder()
            .baseUrl("https://api.chucknorris.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiClient = retrofitClient.create(MeServiceInterface::class.java)

        apiClient.fetchRandomJoke()
            .enqueue(object : Callback<Joke> {
                override fun onFailure(call: Call<Joke>, t: Throwable) {

                }

                override fun onResponse(call: Call<Joke>, response: Response<Joke>) {
                    Log.d("Answer", response.body()?.value)
                }
            })
    }
}