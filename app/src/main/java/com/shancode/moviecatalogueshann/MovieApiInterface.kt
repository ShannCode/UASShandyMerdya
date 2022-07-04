package com.shancode.moviecatalogueshann

import retrofit2.Call
import retrofit2.http.GET

interface MovieApiInterface {

    @GET("/3/movie/popular?api_key=03cc40b6ccbd4a0e9e03c3b47309483c")
    fun getMovieList(): Call<MovieResponse>
}