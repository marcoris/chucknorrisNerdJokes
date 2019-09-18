package ch.risdesign.chucknorrisnerdjokes.model.networking

import ch.risdesign.chucknorrisnerdjokes.model.Joke
import retrofit2.Call
import retrofit2.http.GET

// The interface for the url
interface MyServiceInterface {
    @GET("jokes/random?category=science")
    fun fetchRandomJoke(): Call<Joke>
}