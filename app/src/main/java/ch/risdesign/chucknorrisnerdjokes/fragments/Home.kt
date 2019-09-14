package ch.risdesign.chucknorrisnerdjokes.fragments


import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import ch.risdesign.chucknorrisnerdjokes.R
import ch.risdesign.chucknorrisnerdjokes.helpers.FILE_NAME
import ch.risdesign.chucknorrisnerdjokes.helpers.KEY_FAVORITE
import ch.risdesign.chucknorrisnerdjokes.model.Joke
import ch.risdesign.chucknorrisnerdjokes.model.networking.MyRetrofitClient
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * A simple [Fragment] subclass.
 *
 */
class Home : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Call a joke
        val client = MyRetrofitClient()

        client.apiClient.fetchRandomJoke()
            .enqueue(object : Callback<Joke> {
                override fun onFailure(call: Call<Joke>, t: Throwable) {

                }

                override fun onResponse(call: Call<Joke>, response: Response<Joke>) {
                    val theJoke = response.body()?.value ?: "No body"
                    homeJoke.text  = theJoke

                    // Write
                    context
                        ?.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
                        ?.edit()
                        ?.putString(KEY_FAVORITE, theJoke)
                        ?.apply()
                }
            })

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
}
