package ch.risdesign.chucknorrisnerdjokes.model.networking

import ch.risdesign.chucknorrisnerdjokes.model.Joke
import retrofit2.Call
import retrofit2.http.GET

interface MeServiceInterface {
    @GET("jokes/random")
    fun fetchRandomJoke(): Call<Joke>
}