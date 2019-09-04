package ch.risdesign.chucknorrisnerdjokes.model.networking

import android.util.Log
import android.widget.TextView
import ch.risdesign.chucknorrisnerdjokes.R
import ch.risdesign.chucknorrisnerdjokes.model.Joke
import kotlinx.android.synthetic.main.fragment_home.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
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