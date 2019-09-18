package ch.risdesign.chucknorrisnerdjokes.fragments


import android.app.AlertDialog
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
import ch.risdesign.chucknorrisnerdjokes.helpers.theJoke
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
        // Create client with retrofit
        val client = MyRetrofitClient()

        // Call random joke
        client.apiClient.fetchRandomJoke()
            .enqueue(object : Callback<Joke> {
                override fun onFailure(call: Call<Joke>, t: Throwable) {

                }

                override fun onResponse(call: Call<Joke>, response: Response<Joke>) {
                    // Set random joke and show it on the screen
                    theJoke = response.body()?.value ?: "No body"
                    homeJoke.text  = theJoke
                }
            })

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    // Handle the save joke to favorite button
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Here we have the button
        addToFavorite.setOnClickListener {
            // Write joke in file and show the messages
            val success = context
                ?.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
                ?.edit()
                ?.putString(KEY_FAVORITE, theJoke)
                ?.commit()

            // Show alert dialog with success or error message
            if (success == true) {
                AlertDialog.Builder(it.context).setTitle("Well done")
                    .setMessage("The Chuck Norris NERD joke was successfully saved as your favorite!")
                    .setPositiveButton("OK") {
                            dialog, _ -> dialog.cancel() }
                    .create().show()
            } else {
                AlertDialog.Builder(it.context).setTitle("Uppsy!")
                    .setMessage("There was an error. Try again")
                    .setPositiveButton("OK") {
                            dialog, _ -> dialog.dismiss() }
                    .create().show()
            }
        }
    }
}
